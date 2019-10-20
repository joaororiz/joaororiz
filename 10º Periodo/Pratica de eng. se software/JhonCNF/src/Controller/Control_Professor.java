package Controller;

import Model.BEANS.BEAN_Professor;
import java.util.ArrayList;
import Model.DAOS.DAO_Professor;
import java.sql.SQLException;

public class Control_Professor {

    public Control_Professor() {
    }

    public void addProfessor(BEAN_Professor professor) throws SQLException {
        DAO_Professor.getInstanceProfessor().createProfessor(professor);
    }

    public void updateProfessor(BEAN_Professor professor) throws SQLException {
        DAO_Professor.getInstanceProfessor().updateProfessor(professor);
    }

    public void deleteProfessor(BEAN_Professor professor) throws SQLException {
        DAO_Professor.getInstanceProfessor().deleteProfessor(professor);
    }

    public Boolean isExistProfessor(String usuario, String senha) {
        return DAO_Professor.getInstanceProfessor().isExistUser(usuario, senha);
    }

    public ArrayList<BEAN_Professor> listaProfessoresAtivos() {
        return DAO_Professor.getInstanceProfessor().findAllProfessoresAtivos();
    }

    public ArrayList<BEAN_Professor> listaProfessoresInativos() {
        return DAO_Professor.getInstanceProfessor().findAllProfessoresIntivos();
    }

    public ArrayList<BEAN_Professor> listaProfessoresAtivosByNome(String nome) {
        return DAO_Professor.getInstanceProfessor().findAllProfessoresAtivosByName(nome);
    }

    public ArrayList<BEAN_Professor> listaProfessoresInativosByNome(String nome) {
        return DAO_Professor.getInstanceProfessor().findAllProfessoresInativosByName(nome);
    }
}
