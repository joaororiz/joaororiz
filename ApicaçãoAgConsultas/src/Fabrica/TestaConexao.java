package Fabrica;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        Connection connection = new Conexao().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
