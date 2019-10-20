package Model.DAOS;

import Model.BEANS.BEAN_Disciplina;
import Model.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Disciplina {

    private static DAO_Disciplina instance;

    private DAO_Disciplina() {
        MySQLDAO.getConnection();
    }

    public static DAO_Disciplina getInstanceDisciplina() {
        if (instance == null) {
            instance = new DAO_Disciplina();
        }
        return instance;
    }

    public long createDisciplina(BEAN_Disciplina disciplina) throws SQLException {
        String query = "INSERT INTO disciplina (nomeDisciplina, descricaoDisciplina, faculdade_idFaculdade,  statusDisciplina) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, disciplina.getNomeDisciplina(), disciplina.getDescricaoDisciplina(), disciplina.getIdFaculdade(), disciplina.getStatusDisciplina());
    }

    public void updateDisciplina(BEAN_Disciplina disciplina) throws SQLException {
        String query = "UPDATE disciplina SET nomeDisciplina=?, descricaoDisciplina=?, faculdade_idFaculdade=?, statusDisciplina=? WHERE idDisciplina=?";
        MySQLDAO.executeQuery(query, disciplina.getNomeDisciplina(), disciplina.getDescricaoDisciplina(), disciplina.getIdFaculdade(), disciplina.getStatusDisciplina(), disciplina.getIdDisciplina());
    }

    public void deleteDisciplina(BEAN_Disciplina disciplina) throws SQLException {
        MySQLDAO.executeQuery("UPDATE disciplina  SET statusDisciplina=0 WHERE idDisciplina = ?", disciplina.getIdDisciplina());
    }

    public ArrayList<BEAN_Disciplina> findAllDisciplinasAtivas() {
        return listaDisciplinas("SELECT * FROM disciplina WHERE statusDisciplina = 1 ORDER BY nomeDisciplina");
    }

    public ArrayList<BEAN_Disciplina> findAllDisciplinasInativas() {
        return listaDisciplinas("SELECT * FROM disciplina WHERE statusDisciplina = 0  ORDER BY nomeDisciplina");
    }

    public ArrayList<BEAN_Disciplina> findAllDisciplinasAtivasByName(String nome) {
        return listaDisciplinas("SELECT * FROM disciplina WHERE statusDisciplina = 1  AND nomeDisciplina LIKE '%" + nome + "%' ORDER BY nomeDisciplina");
    }

    public ArrayList<BEAN_Disciplina> findAllDisciplinasInativasByName(String nome) {
        return listaDisciplinas("SELECT * FROM disciplina WHERE statusDisciplina = 0  AND nomeDisciplina LIKE '%" + nome + "%' ORDER BY nomeDisciplina");
    }

    public ArrayList<BEAN_Disciplina> listaDisciplinas(String query) {
        ArrayList<BEAN_Disciplina> listaDisciplinas = new ArrayList<BEAN_Disciplina>();
        ResultSet resultSet = null;
        resultSet = MySQLDAO.getResultSet(query);
        try {
            while (resultSet.next()) {
                listaDisciplinas.add(new BEAN_Disciplina(resultSet.getInt("idDisciplina"), resultSet.getString("nomeDisciplina"), resultSet.getString("descricaoDisciplina"), resultSet.getInt("faculdade_idFaculdade"), resultSet.getString("statusDisciplina")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDisciplinas;
    }
}
