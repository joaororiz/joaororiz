package Controller;

import Model.BEANS.BEAN_Disciplina;
import java.util.ArrayList;
import Model.DAOS.DAO_Disciplina;
import java.sql.SQLException;

public class Control_Disciplina {

    public Control_Disciplina() {
    }

    public void addDisciplina(BEAN_Disciplina disciplina) throws SQLException {
        DAO_Disciplina.getInstanceDisciplina().createDisciplina(disciplina);
    }

    public void updateDisciplina(BEAN_Disciplina disciplina) throws SQLException {
        DAO_Disciplina.getInstanceDisciplina().updateDisciplina(disciplina);
    }

    public void deleteDisciplina(BEAN_Disciplina disciplina) throws SQLException {
        DAO_Disciplina.getInstanceDisciplina().deleteDisciplina(disciplina);
    }
    
    public void ativaDisciplina(BEAN_Disciplina disciplina) throws SQLException {
        DAO_Disciplina.getInstanceDisciplina().ativaDisciplina(disciplina);
    }

    public ArrayList<BEAN_Disciplina> listaDisciplinasAtivas() {
        return DAO_Disciplina.getInstanceDisciplina().findAllDisciplinasAtivas();
    }

    public ArrayList<BEAN_Disciplina> listaDisciplinasInativas() {
        return DAO_Disciplina.getInstanceDisciplina().findAllDisciplinasInativas();
    }

    public ArrayList<BEAN_Disciplina> listaDisciplinasAtivasByNome(String nome) {
        return DAO_Disciplina.getInstanceDisciplina().findAllDisciplinasAtivasByName(nome);
    }

    public ArrayList<BEAN_Disciplina> listaDisciplinasInativasByNome(String nome) {
        return DAO_Disciplina.getInstanceDisciplina().findAllDisciplinasInativasByName(nome);
    }
}
