package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        String sql = String.format("DELETE FROM producer WHERE (id = '%d')", id);
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
            log.info("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    // Geralmente não temos um método que trás todos os usuários em produção
    public static List<Producer> findAll() {
        log.info("Finding all Producers");
        return findByName("");
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding producer by name");
        String sql = String.format("SELECT * FROM producer WHERE name LIKE '%%%s%%'", name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.info("Error while trying to retrieve all Producers", e);
        }
        return producers;
    }

    // Este método provê metadados sobre uma tabela no banco. Isso pode ser útil em casos onde você não acesso ao nome
    // das colunas e você quer saber via Java quais são
    public static void showProducerMetaData() {
        log.info("Showing Producer metadata");
        String sql = "SELECT * FROM producer";
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            log.info("Columns count '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", rsMetaData.getTableName(i));
                log.info("Column name '{}'", rsMetaData.getColumnName(i));
                log.info("Column size '{}'", rsMetaData.getColumnDisplaySize(i));
                log.info("Column type '{}'", rsMetaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            log.info("Error while trying to retrieve all Producers", e);
        }
    }

    // Este método provê informações sobre o driver de conexão que está sendo usado como suporte a FORWARD_ONLY, etc...
    public static void showDriverMetaData() {
        log.info("Showing Driver metadata");
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY: cursor may move only forward ");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE: may change the data while navigating the ResultSet");
                }
            }

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE: scrollable, data changes do not occur on the fly");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE: may change the data while navigating the ResultSet");
                }
            }

            // Poucos drivers implementam esse tipo: Ele permite ver as alterações sem ter que realizar uma nova busca
            // Pois elas acontecem em tempo real, diferente do tipo insensitivo
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE: scrollable, data changes occur on the fly");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE: may change the data while navigating the ResultSet");
                }
            }
        } catch (SQLException e) {
            log.info("Error while trying to retrieve all Producers", e);
        }
    }

    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM anime_store.public.producer";
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {

            log.info("Last row? '{}'", rs.last());
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getLong("id")).name(rs.getString("name")).build());

            log.info("First row? '{}'", rs.first());
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getLong("id")).name(rs.getString("name")).build());

            log.info("Row Absolute? '{}'", rs.absolute(2));
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getLong("id")).name(rs.getString("name")).build());

            log.info("Row Relative? '{}'", rs.relative(-1)); // move o cursor uma linha para trás
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getLong("id")).name(rs.getString("name")).build());

            log.info("is first? '{}'", rs.isFirst());
            log.info("Row number? '{}'", rs.getRow());

            log.info("is last? '{}'", rs.isLast());
            log.info("Row number? '{}'", rs.getRow());

            log.info("Last row? '{}'", rs.last());
            log.info("-----------------------");
            // do último para o primeiro (ignora o último se não posicionar o cursor após rs.last())
            rs.next();
            log.info("After last row? '{}'", rs.isAfterLast());
            while (rs.previous()) {
                log.info(Producer.builder().id(rs.getLong("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        log.info("Finding Producer by name and updating to UpperCase");
        String sql = String.format("SELECT * FROM producer WHERE name LIKE '%%%s%%'", name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rs.updateString("name", rs.getString("name").toUpperCase());
                rs.updateRow();
                Producer producer = Producer
                        .builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }


}
