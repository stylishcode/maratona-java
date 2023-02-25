package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
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

    public static void saveTransaction(List<Producer> producers) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            // não queremos que o banco tome conta de salvar os dados
            conn.setAutoCommit(false);
            preparedStatementSaveTransaction(conn, producers);
            // agora NÓS dizemos quando queremos salvar
            conn.commit();
            // caso estivessemos trabalhando com um método maior (uma conexão por método (lembre que é singleton))
            // precisamos voltar com o commit para true
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            log.info("Error while trying to saving producers '{}'", producers, e);
        }
    }

    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producers)
            throws SQLException {
        String sql = "INSERT INTO anime_store.public.producer (name) VALUES (?);";
        boolean shouldRollback = false;
        for (Producer p : producers) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
               log.info("Saving producer '{}'", p.getName());
               ps.setString(1, p.getName());
               // apenas uma simulação de erro
//               if (p.getName().equals("White fox")) throw new SQLException("Can't save white fox");
               ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                shouldRollback = true;
            }
        }
        if (shouldRollback) {
            // Faz com que os dados que passaram com sucesso (não eram o White fox), também não sejam commitados
            // A transação toda é cancelada, fazendo com que a aplicação volte ao estado anterior
            log.warn("Transaction is going to bem rollback");
            conn.rollback();
        }
    }

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = preparedStatementUpdate(conn, producer)) {
            int rowsAffected = ps.executeUpdate();
            log.info("Updated producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.info("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE producer SET name = ? WHERE (id = ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setLong(2, producer.getId());
        return ps;
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

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        log.info("Finding Producer by name and insert if not found");
        String sql = String.format("SELECT * FROM anime_store.public.producer WHERE name LIKE '%%%s%%'", name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            if (!rs.next()) return producers;
            rs.moveToInsertRow();
            rs.updateString("name", name);
            rs.insertRow();
            // Move o cursor para o ínicio do ResultSet (antes da primeira linha) para retornar a lista já com o nome inserido
            rs.beforeFirst();
            rs.next();
            Producer producer = Producer
                    .builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .build();
            producers.add(producer);
        } catch (SQLException e) {
            log.info("Error while trying to insert a new Producer", e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        log.info("Finding Producer by name and delete");
        String sql = String.format("SELECT * FROM anime_store.public.producer WHERE name LIKE '%%%s%%'", name);
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                log.info("Deleting '{}'", rs.getString("name"));
                // não precisa persistir, ele já exclui direto
                rs.deleteRow();
            }
        } catch (SQLException e) {
            log.info("Error while trying to delete a Producer", e);
        }
    }

    public static List<Producer> findByNameCallableStatement(String name) {
        log.info("Calling a store procedure to find a name");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             CallableStatement cs = callableStatementFindByName(conn, name);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.info("Error while trying to call the store procedure", e);
        }
        return producers;
    }

    private static CallableStatement callableStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.public.sp_get_producer_by_name(?)";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, String.format("%%%s%%", name));
        return cs;
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        log.info("Finding producer by name prepared statement");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = preparedStatementByName(conn, name);
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
            throw new RuntimeException(e);
        }
        return producers;
    }

    private static PreparedStatement preparedStatementByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.public.producer WHERE name like ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }
}
