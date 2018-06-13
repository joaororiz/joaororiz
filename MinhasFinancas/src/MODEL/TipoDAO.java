/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class TipoDAO {
    
    private static TipoDAO instance;

    public TipoDAO() {
        MySQLDAO.getConnection();
    }

    public static TipoDAO getInstance() {
        if (instance == null) {
            instance = new TipoDAO();
        }
        return instance;
    }
    
    public String getDescricao(int id){
        String descricao = null;
        String query = "SELECT * FROM `tipo` WHERE `id` = "+ id +" ORDER BY `id` ASC";
        ResultSet rs = MySQLDAO.getResultSet(query);
        try {
            if (rs.next()) {
                descricao = rs.getString("descricao");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descricao;
    }
    
}
