package academy.devdojo.maratonajava.javacore.ZZIjdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory instance;

    private Connection connection;
    private JdbcRowSet jdbcRowSet;

    private final String URL = "jdbc:postgresql://localhost:5432/anime_store";
    private final String USERNAME = "admin";
    private final String PASSWORD = "root";

    private ConnectionFactory() {
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public JdbcRowSet getJdbcRowSet() throws SQLException {
        if (jdbcRowSet == null) {
            jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(URL);
            jdbcRowSet.setUsername(USERNAME);
            jdbcRowSet.setPassword(PASSWORD);
        }
        return jdbcRowSet;
    }

    public CachedRowSet getCachedRowSet() throws SQLException {
        return RowSetProvider.newFactory().createCachedRowSet();
    }
}
