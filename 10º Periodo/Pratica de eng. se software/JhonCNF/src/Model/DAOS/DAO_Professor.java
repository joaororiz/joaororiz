package Model.DAOS;

import Model.BEANS.BEAN_Professor;
import Model.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Professor {

    private static DAO_Professor instance;

    private DAO_Professor() {
        MySQLDAO.getConnection();
    }

    public static DAO_Professor getInstanceProfessor() {
        if (instance == null) {
            instance = new DAO_Professor();
        }
        return instance;
    }

    public long createProfessor(BEAN_Professor professor) throws SQLException {
        String query = "INSERT INTO professor (nomeProfessor, dataNascimentoProfessor, usuarioProfessor, senhaProfessor, statusProfessor) VALUES (?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, professor.getNomeProfessor(), professor.getDataNascimentoProfessor(), professor.getUsuarioProfessor(), professor.getSenhaProfessor(), professor.getStatusProfessor());
    }

    public void updateProfessor(BEAN_Professor professor) throws SQLException {
        String query = "UPDATE professor SET nomeProfessor=?, dataNascimentoProfessor=?, usuarioProfessor=?, senhaProfessor=?, statusProfessor=? WHERE idProfessor = ?";
        MySQLDAO.executeQuery(query, professor.getNomeProfessor(), professor.getDataNascimentoProfessor(), professor.getUsuarioProfessor(), professor.getSenhaProfessor(), professor.getStatusProfessor(), professor.getIdProfessor());
    }

    public void deleteProfessor(BEAN_Professor professor) throws SQLException {
        MySQLDAO.executeQuery("UPDATE professor SET statusProfessor=0 WHERE idProfessor = ?", professor.getIdProfessor());
    }

    public ArrayList<BEAN_Professor> findAllProfessoresAtivos() {
        return listaProfessores("SELECT * FROM professor WHERE statusProfessor=1 ORDER BY nomeProfessor");
    }

    public ArrayList<BEAN_Professor> findAllProfessoresIntivos() {
        return listaProfessores("SELECT * FROM professor WHERE statusProfessor=0 ORDER BY nomeProfessor");
    }

    public ArrayList<BEAN_Professor> findAllProfessoresAtivosByName(String nome) {
        return listaProfessores("SELECT * FROM professor WHERE statusProfessor=1 AND nomeProfessor  LIKE '%" + nome + "%' ORDER BY nomeProfessor");
    }

    public ArrayList<BEAN_Professor> findAllProfessoresInativosByName(String nome) {
        return listaProfessores("SELECT * FROM professor WHERE statusProfessor=0 AND nomeProfessor LIKE '%" + nome + "%' ORDER BY nomeProfessor");
    }

    public ArrayList<BEAN_Professor> listaProfessores(String query) {
        ArrayList<BEAN_Professor> listaProfessors = new ArrayList<BEAN_Professor>();
        ResultSet resultSet = null;
        resultSet = MySQLDAO.getResultSet(query);
        try {
            while (resultSet.next()) {
                listaProfessors.add(new BEAN_Professor(resultSet.getInt("idProfessor"), resultSet.getString("nomeProfessor"), resultSet.getDate("dataNascimentoProfessor"), resultSet.getString("usuarioProfessor"), resultSet.getString("senhaProfessor"), resultSet.getString("statusProfessor")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProfessors;
    }

    public Boolean isExistUser(String user, String password) {
        Boolean result = false;
        ResultSet resultSet = null;
        resultSet = MySQLDAO.getResultSet("SELECT * FROM professor WHERE usuarioProfessor= ? AND senhaProfessor=?", user, password);
        try {
            if (resultSet.next()) {
                result = true;
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
