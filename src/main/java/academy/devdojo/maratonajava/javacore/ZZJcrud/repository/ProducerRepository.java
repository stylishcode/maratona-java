package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public final class ProducerRepository {
    public static List<Producer> findByName(String name) {
        log.info(MessageLog.ON_TRY_FIND.MESSAGE, name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createFindPreparedStatement(conn, name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.info(MessageLog.ERR_ON_FIND.MESSAGE, e);
        }
        return producers;
    }

    private static PreparedStatement createFindPreparedStatement(Connection conn, String name) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Query.FIND_BY_NAME.SQL);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }
}

enum Query {
    SAVE("INSERT INTO anime_store.public.producer name VALUES ?"),
    FIND_BY_NAME("SELECT * FROM anime_store.public.producer WHERE name LIKE ?"),
    DELETE("DELETE FROM anime_store.public.producer WHERE id = ?"),
    UPDATE("UPDATE anime_store.public.producer SET name = ? WHERE id = ?");

    public final String SQL;

    Query(String sqlQuery) {
        this.SQL = sqlQuery;
    }
}

enum MessageLog {
    ON_SAVE("Inserted producer '{}' in database, rows affected '{}'"),
    ON_DELETE("Deleted producer '{}' from the database, rows affected '{}'"),
    ON_TRY_FIND("Finding producer by name '{}'"),
    ON_UDPATE("Updated producer '{}', rows affected '{}'"),

    ERR_ON_SAVE("Error while trying to save producer '{}'"),
    ERR_ON_FIND("Error while trying to retrieve producers"),
    ERR_ON_UPDATE("Error while trying to update producer '{}'"),
    ERR_ON_DELETE("Error while trying to delete producer '{}'");

    public final String MESSAGE;

    MessageLog(String message) {
        this.MESSAGE = message;
    }
}