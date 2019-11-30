package Model.DAOS;

import Model.BEANS.BEAN_Aluno;
import Model.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Aluno {

    private static DAO_Aluno instance;

    private DAO_Aluno() {
        MySQLDAO.getConnection();
    }

    public static DAO_Aluno getInstanceAluno() {
        if (instance == null) {
            instance = new DAO_Aluno();
        }
        return instance;
    }

    public long createAluno(BEAN_Aluno aluno) throws SQLException {
        String query = "INSERT INTO aluno (nomeAluno, CPFAluno, dataNascimentoAluno, statusAluno) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, aluno.getNomeAluno(), aluno.getCPFAluno(), aluno.getDataNascimentoAluno(), aluno.getStatusAluno());
    }

    public void updateAluno(BEAN_Aluno aluno) throws SQLException {
        String query = "UPDATE aluno SET nomeAluno=?, CPFAluno=?, dataNascimentoAluno=?, statusAluno=? WHERE idAluno = ?";
        MySQLDAO.executeQuery(query, aluno.getNomeAluno(), aluno.getCPFAluno(), aluno.getDataNascimentoAluno(), aluno.getStatusAluno(), aluno.getIdAluno());
    }

    public void deleteAluno(BEAN_Aluno aluno) throws SQLException {
        MySQLDAO.executeQuery("UPDATE aluno SET statusAluno=0 WHERE idAluno = ?", aluno.getIdAluno());
    }

    public ArrayList<BEAN_Aluno> findAllAlunosAtivos() {
        return listaAlunoes("SELECT * FROM aluno WHERE statusAluno=1 ORDER BY nomeAluno");
    }

    public ArrayList<BEAN_Aluno> findAllAlunosIntivos() {
        return listaAlunoes("SELECT * FROM aluno WHERE statusAluno=0 ORDER BY nomeAluno");
    }

    public ArrayList<BEAN_Aluno> findAllAlunosAtivosByName(String nome) {
        return listaAlunoes("SELECT * FROM aluno WHERE statusAluno=1 AND nomeAluno  LIKE '%" + nome + "%' ORDER BY nomeAluno");
    }

    public ArrayList<BEAN_Aluno> findAllAlunosInativosByName(String nome) {
        return listaAlunoes("SELECT * FROM aluno WHERE statusAluno=0 AND nomeAluno LIKE '%" + nome + "%' ORDER BY nomeAluno");
    }

    public ArrayList<BEAN_Aluno> listaAlunoes(String query) {
        ArrayList<BEAN_Aluno> listaAlunos = new ArrayList<BEAN_Aluno>();
        ResultSet resultSet = null;
        resultSet = MySQLDAO.getResultSet(query);
        try {
            while (resultSet.next()) {
                listaAlunos.add(new BEAN_Aluno(resultSet.getInt("idAluno"), resultSet.getString("nomeAluno"), resultSet.getString("CPFAluno"), resultSet.getDate("dataNascimentoAluno"), resultSet.getString("statusAluno")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlunos;
    }

    public Boolean isExistUser(BEAN_Aluno aluno) {
        Boolean result = false;
        ResultSet resultSet = null;
        resultSet = MySQLDAO.getResultSet("SELECT * FROM aluno WHERE idAluno=?", aluno.getIdAluno());
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
