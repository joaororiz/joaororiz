package Dao;

import Conexao.MySQLDAO;
import Modelo.ConsultaBEAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ConsultasDAO {

    private Connection connection;

    public ConsultasDAO() {
        this.connection = new MySQLDAO().getConnection();
    }

    public void adicionaConsulta(ConsultaBEAN consulta) {
        String sql = "INSERT INTO consulta(idPaciente,idMedico,dataConsulta,descricao) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, consulta.getPaciente());
            stmt.setString(2, consulta.getMedico());
            stmt.setString(3, consulta.getDataconsulta());
            stmt.setString(4, consulta.getDescrisao());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public List<ConsultaBEAN> findByAllConsultas() throws SQLException {
        String sql = "SELECT * FROM consulta ORDER BY dataConsulta ASC";
        List<ConsultaBEAN> listConsultas = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ConsultaBEAN consultaBEAN = new ConsultaBEAN();
            consultaBEAN.setPaciente(rs.getString(2));
            consultaBEAN.setMedico(rs.getString(3));
            consultaBEAN.setDataconsulta(rs.getString(4));
            consultaBEAN.setDescrisao(rs.getString(5));
            listConsultas.add(consultaBEAN);
        }
        rs.close();
        return listConsultas;
    }
}
