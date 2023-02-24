package academy.devdojo.maratonajava.javacore.ZZIjdbc.conn;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    private Connection connection;
    private JdbcRowSet jdbcRowSet;

    private ConnectionFactory() {}

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/anime_store";
            String username = "admin";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public JdbcRowSet getJdbcRowSet() throws SQLException {
       if (jdbcRowSet == null) {
           String url = "jdbc:postgresql://localhost:5432/anime_store";
           String username = "admin";
           String password = "root";
           jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
           jdbcRowSet.setUrl(url);
           jdbcRowSet.setUsername(username);
           jdbcRowSet.setPassword(password);
       }
       return jdbcRowSet;
    }
}
