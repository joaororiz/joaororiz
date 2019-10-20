package Controller;

import java.util.ArrayList;

import Model.ContatosBEAN;
import Model.ContatosDAO;
import java.sql.SQLException;

public class Controle {

    public Controle() {
    }

    public void addContato(ContatosBEAN contato) throws SQLException {
        ContatosDAO.getInstance().create(contato);
    }

    public void updateContato(ContatosBEAN contato) throws SQLException {
        ContatosDAO.getInstance().update(contato);
    }

    public void deleteContato(ContatosBEAN contato) throws SQLException {
        ContatosDAO.getInstance().delete(contato);
    }

    public ContatosBEAN findPessoa(int id) {
        return ContatosDAO.getInstance().findContato(id);
    }

    public int findIdContato(ContatosBEAN contato) {
        return ContatosDAO.getInstance().findId(contato);
    }

    public Boolean isExist(int id) {
        return ContatosDAO.getInstance().isExist(id);
    }

    public ArrayList<ContatosBEAN> listaContatos() {
        return ContatosDAO.getInstance().findAllPessoa();
    }
}
