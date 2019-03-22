package Dao;

import Conexao.MySQLDAO;
import Modelo.UsuarioBEAN;
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
public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        this.connection = new MySQLDAO().getConnection();
    }

    public void adicionaUsuario(UsuarioBEAN usuario) {
        String sql = "INSERT INTO usuario(nome,cpf,email,telefone,tipoUser) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getTipo());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public List<String> findByEmails() throws SQLException {
        String sql = "SELECT * FROM usuario ORDER BY email ASC";
        List<String> listaDeEmails = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            listaDeEmails.add(rs.getString(4));
        }
        rs.close();
        return listaDeEmails;
    }

    public List<UsuarioBEAN> findByAllUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuario ORDER BY email ASC";
        List<UsuarioBEAN> listUsuarios = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            UsuarioBEAN usuarioBEAN = new UsuarioBEAN();
            usuarioBEAN.setNome(rs.getString(2));
            usuarioBEAN.setCpf(rs.getString(3));
            usuarioBEAN.setEmail(rs.getString(4));
            usuarioBEAN.setTelefone(rs.getString(5));
            usuarioBEAN.setTipo(rs.getString(6));
            listUsuarios.add(usuarioBEAN);
        }
        rs.close();
        return listUsuarios;
    }
    
    public List<UsuarioBEAN> findByAllPacientes() throws SQLException {
        String sql = "SELECT * FROM usuario WHERE usuario.tipoUser = 'Paciente' ORDER BY usuario.nome ASC";
        List<UsuarioBEAN> listPacientes = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            UsuarioBEAN usuarioBEAN = new UsuarioBEAN();
            usuarioBEAN.setNome(rs.getString(2));
            usuarioBEAN.setCpf(rs.getString(3));
            usuarioBEAN.setEmail(rs.getString(4));
            usuarioBEAN.setTelefone(rs.getString(5));
            usuarioBEAN.setTipo(rs.getString(6));
            listPacientes.add(usuarioBEAN);
        }
        rs.close();
        return listPacientes;
    }
    
    public List<UsuarioBEAN> findByAllMedicos() throws SQLException {
        String sql = "SELECT * FROM usuario WHERE usuario.tipoUser = 'Médico' ORDER BY usuario.nome ASC";
        List<UsuarioBEAN> listMedicos = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            UsuarioBEAN usuarioBEAN = new UsuarioBEAN();
            usuarioBEAN.setNome(rs.getString(2));
            usuarioBEAN.setCpf(rs.getString(3));
            usuarioBEAN.setEmail(rs.getString(4));
            usuarioBEAN.setTelefone(rs.getString(5));
            usuarioBEAN.setTipo(rs.getString(6));
            listMedicos.add(usuarioBEAN);
        }
        rs.close();
        return listMedicos;
    }
    

    public boolean isExistsCPF(String emailSelect, String cpfInfo) throws SQLException {
        String query = "SELECT * FROM usuario WHERE email = '" + emailSelect + "' AND cpf = '" + cpfInfo + "'";
        boolean resultado = false;
        ResultSet rs = MySQLDAO.getResultSet(query);
        try {
            if (rs.next()) {
                resultado = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
