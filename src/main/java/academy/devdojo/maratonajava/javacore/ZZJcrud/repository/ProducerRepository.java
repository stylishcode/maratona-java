package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;

import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public final class ProducerRepository {
    public static List<Producer> findByName(String name) {
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createFindByNamePreparedStatement(conn, name);
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
            log.info(ProducerErrorMessage.ON_FIND.MESSAGE, e);
        }
        return producers;
    }

    private static PreparedStatement createFindByNamePreparedStatement(Connection conn, String name) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(ProducerQuery.FIND_BY_NAME.SQL);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    public static Optional<Producer> findById(Long id) {
        Optional<Producer> producer = Optional.empty();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createFindByIdPreparedStatement(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                producer = Optional.of(Producer
                        .builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .build());
            }
        } catch (SQLException e) {
            log.info(ProducerErrorMessage.ON_FIND.MESSAGE, e);
        }
        return producer;
    }

    private static PreparedStatement createFindByIdPreparedStatement(Connection conn, Long id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(ProducerQuery.FIND_BY_ID.SQL);
        ps.setLong(1, id);
        return ps;
    }

    public static void update(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createUpdatePreparedStatement(conn, producer)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createUpdatePreparedStatement(Connection conn, Producer producer) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(ProducerQuery.UPDATE.SQL);
        ps.setString(1, producer.getName());
        ps.setLong(2, producer.getId());
        return ps;
    }


    public static void delete(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = deletePreparedStatement(conn, id)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.info(ProducerErrorMessage.ON_DELETE.MESSAGE, id, e);
        }
    }

    private static PreparedStatement deletePreparedStatement(Connection conn, Long id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(ProducerQuery.DELETE.SQL);
        ps.setLong(1, id);
        return ps;
    }

    public static void save(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createSavePreparedStatement(conn, producer)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.info(ProducerErrorMessage.ON_SAVE.MESSAGE, producer.getName(), e);
        }
    }

    private static PreparedStatement createSavePreparedStatement(Connection conn, Producer producer) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(ProducerQuery.SAVE.SQL);
        ps.setString(1, producer.getName());
        return ps;
    }

}

enum ProducerQuery {
    SAVE("INSERT INTO anime_store.public.producer (name) VALUES (?)"),
    FIND_BY_NAME("SELECT * FROM anime_store.public.producer WHERE name LIKE ?"),
    FIND_BY_ID("SELECT * FROM anime_store.public.producer WHERE id = ?"),
    DELETE("DELETE FROM anime_store.public.producer WHERE id = ?"),
    UPDATE("UPDATE anime_store.public.producer SET name = ? WHERE id = ?");

    public final String SQL;

    ProducerQuery(String sql) {
        this.SQL = sql;
    }
}

enum ProducerErrorMessage {
    ON_SAVE("Error while trying to save producer '{}'"),
    ON_FIND("Error while trying to retrieve producers"),
    ON_UPDATE("Error while trying to update producer '{}'"),
    ON_DELETE("Error while trying to delete producer '{}'");

    public final String MESSAGE;

    ProducerErrorMessage(String message) {
        this.MESSAGE = message;
    }
}