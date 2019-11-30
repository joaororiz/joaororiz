package Model.DAOS;

import Model.BEANS.BEAN_Aluno;
import Model.BEANS.BEAN_Turma;
import Model.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Turma {

    private static DAO_Turma instance;

    private DAO_Turma() {
        MySQLDAO.getConnection();
    }

    public static DAO_Turma getInstanceTurma() {
        if (instance == null) {
            instance = new DAO_Turma();
        }
        return instance;
    }

    public long createTurma(BEAN_Turma turma, BEAN_Aluno aluno) throws SQLException {
        this.createAuxTurmaAluno(aluno.getIdAluno(), turma.getIdTurma());
        String query = "INSERT INTO turma (nomeTurma, descricaoTurma, disciplina_idDisciplina, professor_idProfessor, statusTurma) VALUES (?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, turma.getNomeTurma(), turma.getDescricaoTurma(), turma.getDisciplina_idDisciplina(), turma.getProfessor_idProfessor(), turma.getStatusTurma());
    }

    private long createAuxTurmaAluno(int idAluno, int idTurma) throws SQLException {
        String query = "INSERT INTO aluno_has_turma (aluno_idAluno, turma_idTurma) VALUES (?, ?)";
        return MySQLDAO.executeQuery(query, idAluno, idTurma);
    }

    public void updateTurma(BEAN_Turma turma, BEAN_Aluno aluno) throws SQLException {
//          this.updateAuxTurmaAluno(aluno.getIdAluno(), turma.getIdTurma());
        String query = "UPDATE turma SET nomeTurma=?, descricaoTurma=?, disciplina_idDisciplina=?, professor_idProfessor=?, statusTurma=? WHERE idTurma=?";
        MySQLDAO.executeQuery(query, turma.getNomeTurma(), turma.getDescricaoTurma(), turma.getDisciplina_idDisciplina(), turma.getProfessor_idProfessor(), turma.getStatusTurma(), turma.getIdTurma());
    }

    private long updateAuxTurmaAluno(int idAluno, int idTurma) throws SQLException {
        String query = "UPDATE aluno_has_turma SET aluno_idAluno=?, turma_idTurma=? WHERE aluno_idAluno? AND turma_idTurma=?";
        return MySQLDAO.executeQuery(query, idAluno, idTurma);
    }

    public void deleteTurma(BEAN_Turma turma) throws SQLException {
        MySQLDAO.executeQuery("UPDATE turma  SET statusTurma=0 WHERE idTurma = ?", turma.getIdTurma());
    }

    public ArrayList<BEAN_Turma> findAllTurmasAtivas() {
        return listaTurmas("SELECT * FROM turma WHERE statusTurma = 1 ORDER BY nomeTurma");
    }

    public ArrayList<BEAN_Turma> findAllTurmasInativas() {
        return listaTurmas("SELECT * FROM turma WHERE statusTurma = 0  ORDER BY nomeTurma");
    }

    public ArrayList<BEAN_Turma> findAllTurmasAtivasByName(String nome) {
        return listaTurmas("SELECT * FROM turma WHERE statusTurma = 1  AND nomeTurma LIKE '%" + nome + "%' ORDER BY nomeTurma");
    }

    public ArrayList<BEAN_Turma> findAllTurmasInativasByName(String nome) {
        return listaTurmas("SELECT * FROM turma WHERE statusTurma = 0  AND nomeTurma LIKE '%" + nome + "%' ORDER BY nomeTurma");
    }

    public ArrayList<BEAN_Turma> listaTurmas(String query) {
        ArrayList<BEAN_Turma> listaTurmas = new ArrayList<BEAN_Turma>();
        ResultSet resultSet = null;
        resultSet = MySQLDAO.getResultSet(query);
        try {
            while (resultSet.next()) {
                listaTurmas.add(new BEAN_Turma(resultSet.getInt("idTurma"), resultSet.getString("nomeTurma"), resultSet.getString("descricaoTurma"), resultSet.getInt("disciplina_idDisciplina"), resultSet.getInt("professor_idProfessor"), resultSet.getString("statusTurma")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaTurmas;
    }
}
