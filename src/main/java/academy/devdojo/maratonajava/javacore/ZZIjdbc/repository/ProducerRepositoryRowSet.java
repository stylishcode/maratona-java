package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "SELECT * FROM anime_store.public.producer WHERE name LIKE ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getInstance().getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", name));
            // somente para buscar dados, não serve para inserir
            jrs.execute();
            while (jrs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(jrs.getLong("id"))
                        .name(jrs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static void updateJdbcRowSet(Producer producer) {
        String sql = "SELECT * FROM anime_store.public.producer WHERE (id = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getInstance().getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setLong(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateCachedRowSet(Producer producer) {
        String sql = "SELECT * FROM anime_store.public.producer WHERE (id = ?);";
        try (CachedRowSet crs = ConnectionFactory.getInstance().getCachedRowSet();
             Connection conn = ConnectionFactory.getInstance().getConnection()) {
            // necessário não é possível chamar o acceptChanges() se estiver true
            conn.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setLong(1, producer.getId());
            crs.execute(conn);
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            // Como o CachedRowSet trabalha em memória (desconectado do banco). Para persistir uma atualização
            // é necessário reconectar com o banco, para isso precisamos desse método abaixo, porém ainda não é
            // o suficiente
            crs.acceptChanges();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
