package Fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joaoo
 */
public class Conexao {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/consultasbd", "root", "");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
