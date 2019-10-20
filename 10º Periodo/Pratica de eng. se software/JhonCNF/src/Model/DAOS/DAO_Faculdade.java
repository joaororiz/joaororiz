package Model.DAOS;

import Model.BEANS.BEAN_Faculdade;
import Model.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Faculdade {

    private static DAO_Faculdade instance;

    private DAO_Faculdade() {
        MySQLDAO.getConnection();
    }

    public static DAO_Faculdade getInstanceFaculdade() {
        if (instance == null) {
            instance = new DAO_Faculdade();
        }
        return instance;
    }

    public long createFaculdade(BEAN_Faculdade faculdade) throws SQLException {
        String query = "INSERT INTO faculdade (nomeFaculdade, descricaoFaculdade, UFfaculdade, cidadeFaculdade, statusFaculdade) VALUES (?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, faculdade.getNomeFaculdade(), faculdade.getDescricaoFaculdade(), faculdade.getUFfaculdade(), faculdade.getCidadeFaculdade(), faculdade.getStatusFaculdade());
    }

    public void updateFaculdade(BEAN_Faculdade faculdade) throws SQLException {
        String query = "UPDATE faculdade SET nomeFaculdade=?, descricaoFaculdade=?, UFfaculdade=?, cidadeFaculdade=?, statusFaculdade=? WHERE idFaculdade=?";
        MySQLDAO.executeQuery(query, faculdade.getNomeFaculdade(), faculdade.getDescricaoFaculdade(), faculdade.getUFfaculdade(), faculdade.getCidadeFaculdade(), faculdade.getStatusFaculdade(), faculdade.getIdFaculdade());
    }

    public void deleteFaculdade(BEAN_Faculdade faculdade) throws SQLException {
        MySQLDAO.executeQuery("UPDATE faculdade SET statusFaculdade=0 WHERE idFaculdade=?", faculdade.getIdFaculdade());
    }

    public ArrayList<BEAN_Faculdade> findAllFaculdadesAtivas() {
        return listaFaculdades("SELECT * FROM faculdade WHERE statusFaculdade = 1 ORDER BY nomeFaculdade");
    }

    public ArrayList<BEAN_Faculdade> findAllFaculdadeInativas() {
        return listaFaculdades("SELECT * FROM faculdade WHERE statusFaculdade = 0 ORDER BY nomeFaculdade");
    }

    public ArrayList<BEAN_Faculdade> findAllFaculdadesAtivasByName(String nome) {
        return listaFaculdades("SELECT * FROM faculdade WHERE statusFaculdade = 1 AND nomeFaculdade LIKE '%" + nome + "%' ORDER BY nomeFaculdade");
    }

    public ArrayList<BEAN_Faculdade> findAllFaculdadesInativasByName(String nome) {
        return listaFaculdades("SELECT * FROM faculdade WHERE statusFaculdade = 0 AND nomeFaculdade LIKE '%" + nome + "%' ORDER BY nomeFaculdade");
    }

    public ArrayList<BEAN_Faculdade> listaFaculdades(String query) {
        ArrayList<BEAN_Faculdade> listaFaculdades = new ArrayList<BEAN_Faculdade>();
        ResultSet resultSet = null;
        resultSet = MySQLDAO.getResultSet(query);
        try {
            while (resultSet.next()) {
                listaFaculdades.add(new BEAN_Faculdade(resultSet.getInt("idFaculdade"), resultSet.getString("nomeFaculdade"), resultSet.getString("descricaoFaculdade"), resultSet.getString("UFfaculdade"), resultSet.getString("cidadeFaculdade"), resultSet.getString("statusFaculdade")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFaculdades;
    }
}
