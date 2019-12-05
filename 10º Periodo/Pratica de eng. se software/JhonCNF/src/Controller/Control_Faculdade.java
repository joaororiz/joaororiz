package Controller;

import Model.BEANS.BEAN_Faculdade;
import java.util.ArrayList;
import Model.DAOS.DAO_Faculdade;
import java.sql.SQLException;

public class Control_Faculdade {

    public Control_Faculdade() {
    }

    public void addFaculdade(BEAN_Faculdade faculdade) throws SQLException {
        DAO_Faculdade.getInstanceFaculdade().createFaculdade(faculdade);
    }

    public void updateFaculdade(BEAN_Faculdade faculdade) throws SQLException {
        DAO_Faculdade.getInstanceFaculdade().updateFaculdade(faculdade);
    }

    public void deleteFaculdade(BEAN_Faculdade faculdade) throws SQLException {
        DAO_Faculdade.getInstanceFaculdade().deleteFaculdade(faculdade);
    }
    
    public void ativaFaculdade(BEAN_Faculdade faculdade) throws SQLException {
        DAO_Faculdade.getInstanceFaculdade().ativaFaculdade(faculdade);
    }

    public ArrayList<BEAN_Faculdade> listaFaculdades() {
        return DAO_Faculdade.getInstanceFaculdade().findAllFaculdades();
    }
    
    public ArrayList<BEAN_Faculdade> listaFaculdadesAtivas() {
        return DAO_Faculdade.getInstanceFaculdade().findAllFaculdadesAtivas();
    }

    public ArrayList<BEAN_Faculdade> listaFaculdadesInativas() {
        return DAO_Faculdade.getInstanceFaculdade().findAllFaculdadeInativas();
    }

    public ArrayList<BEAN_Faculdade> listaFaculdadesAtivasByNome(String nome) {
        return DAO_Faculdade.getInstanceFaculdade().findAllFaculdadesAtivasByName(nome);
    }

    public ArrayList<BEAN_Faculdade> listaFaculdadesInativasByNome(String nome) {
        return DAO_Faculdade.getInstanceFaculdade().findAllFaculdadesInativasByName(nome);
    }
}
