package Controller;

import Model.BEANS.BEAN_Aluno;
import Model.BEANS.BEAN_Turma;
import java.util.ArrayList;
import Model.DAOS.DAO_Turma;
import java.sql.SQLException;

public class Control_Turma {

    public Control_Turma() {
    }

    public void addTurma(BEAN_Turma turma, BEAN_Aluno aluno)throws SQLException {
        DAO_Turma.getInstanceTurma().createTurma(turma, aluno);
    }

    public void updateTurma(BEAN_Turma turma, BEAN_Aluno aluno) throws SQLException {
        DAO_Turma.getInstanceTurma().updateTurma(turma, aluno);
    }

    public void deleteTurma(BEAN_Turma turma) throws SQLException {
        DAO_Turma.getInstanceTurma().deleteTurma(turma);
    }

    public ArrayList<BEAN_Turma> listaTurmasAtivas() {
        return DAO_Turma.getInstanceTurma().findAllTurmasAtivas();
    }

    public ArrayList<BEAN_Turma> listaTurmasInativas() {
        return DAO_Turma.getInstanceTurma().findAllTurmasInativas();
    }

    public ArrayList<BEAN_Turma> listaTurmasAtivasByNome(String nome) {
        return DAO_Turma.getInstanceTurma().findAllTurmasAtivasByName(nome);
    }

    public ArrayList<BEAN_Turma> listaTurmasInativasByNome(String nome) {
        return DAO_Turma.getInstanceTurma().findAllTurmasInativasByName(nome);
    }
}
