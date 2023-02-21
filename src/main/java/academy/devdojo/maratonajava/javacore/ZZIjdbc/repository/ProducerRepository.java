package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer) {
        String sql = String.format("INSERT INTO producer (name) VALUES ('%s')", producer.getName());
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' in database, rows affected '{}'", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.info("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }


    public static void delete(Long id) {
        String sql = String.format("DElETE FROM producer WHERE (id = '%d')", id);
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' from the database, rows affected '{}'", id, rowsAffected);
        } catch (SQLException e) {
            log.info("Error while trying to delte producer '{}'", id, e);
        }
    }

    public static void update(Producer producer) {
        String sql = String.format("UPDATE producer SET name = '%s' WHERE (id = '%d')", producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Updated producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.info("Error while trying to delte producer '{}'", producer.getId(), e);
        }
    }
}
