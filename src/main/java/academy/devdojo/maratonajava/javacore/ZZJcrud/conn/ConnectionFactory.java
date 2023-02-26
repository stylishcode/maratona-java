package academy.devdojo.maratonajava.javacore.ZZJcrud.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/anime_store";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "root";

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}