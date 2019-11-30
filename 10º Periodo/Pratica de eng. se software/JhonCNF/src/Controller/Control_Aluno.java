package Controller;

import Model.BEANS.BEAN_Aluno;
import java.util.ArrayList;
import Model.DAOS.DAO_Aluno;
import java.sql.SQLException;

public class Control_Aluno {

    public Control_Aluno() {
    }

    public void addAluno(BEAN_Aluno aluno) throws SQLException {
        DAO_Aluno.getInstanceAluno().createAluno(aluno);
    }

    public void updateAluno(BEAN_Aluno aluno) throws SQLException {
        DAO_Aluno.getInstanceAluno().updateAluno(aluno);
    }

    public void deleteAluno(BEAN_Aluno aluno) throws SQLException {
        DAO_Aluno.getInstanceAluno().deleteAluno(aluno);
    }

    public ArrayList<BEAN_Aluno> listaAlunoesAtivos() {
        return DAO_Aluno.getInstanceAluno().findAllAlunosAtivos();
    }

    public ArrayList<BEAN_Aluno> listaAlunoesInativos() {
        return DAO_Aluno.getInstanceAluno().findAllAlunosIntivos();
    }

    public ArrayList<BEAN_Aluno> listaAlunoesAtivosByNome(String nome) {
        return DAO_Aluno.getInstanceAluno().findAllAlunosAtivosByName(nome);
    }

    public ArrayList<BEAN_Aluno> listaAlunoesInativosByNome(String nome) {
        return DAO_Aluno.getInstanceAluno().findAllAlunosInativosByName(nome);
    }
}
