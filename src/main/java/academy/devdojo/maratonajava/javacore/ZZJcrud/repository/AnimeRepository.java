package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;

import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.domain.Anime;
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
public final class AnimeRepository {
    public static List<Anime> findByName(String name) {
        List<Anime> animes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createFindByNamePreparedStatement(conn, name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getLong("producer_id"))
                        .name(rs.getString("producer_name"))
                        .build();
                Anime anime = Anime
                        .builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .episodes(rs.getInt("episodes"))
                        .producer(producer)
                        .build();
                animes.add(anime);
            }
        } catch (SQLException e) {
            log.info(AnimeErrorMessage.ON_FIND.MESSAGE, e);
        }
        return animes;
    }

    private static PreparedStatement createFindByNamePreparedStatement(Connection conn, String name) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(AnimeQuery.FIND_BY_NAME_AND_INNER_JOIN_WITH_PRODUCER.SQL);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    public static Optional<Anime> findById(Long id) {
        Optional<Anime> anime = Optional.empty();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createFindByIdPreparedStatement(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getLong("producer_id"))
                        .name(rs.getString("producer_name"))
                        .build();
                anime = Optional.of(Anime
                        .builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .episodes(rs.getInt("episodes"))
                        .producer(producer)
                        .build());
            }
        } catch (SQLException e) {
            log.info(AnimeErrorMessage.ON_FIND.MESSAGE, e);
        }
        return anime;
    }

    private static PreparedStatement createFindByIdPreparedStatement(Connection conn, Long id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(AnimeQuery.FIND_BY_ID_AND_INNER_JOIN_WITH_PRODUCER.SQL);
        ps.setLong(1, id);
        return ps;
    }

    public static void update(Anime anime) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createUpdatePreparedStatement(conn, anime)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement createUpdatePreparedStatement(Connection conn, Anime anime) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(AnimeQuery.UPDATE.SQL);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setLong(3, anime.getId());
        return ps;
    }


    public static void delete(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = deletePreparedStatement(conn, id)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.info(AnimeErrorMessage.ON_DELETE.MESSAGE, id, e);
        }
    }

    private static PreparedStatement deletePreparedStatement(Connection conn, Long id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(AnimeQuery.DELETE.SQL);
        ps.setLong(1, id);
        return ps;
    }

    public static void save(Anime anime) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createSavePreparedStatement(conn, anime)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.info(AnimeErrorMessage.ON_SAVE.MESSAGE, anime.getName(), e);
        }
    }

    private static PreparedStatement createSavePreparedStatement(Connection conn, Anime anime) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(AnimeQuery.SAVE.SQL);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setLong(3, anime.getProducer().getId());
        return ps;
    }

}

enum AnimeQuery {
    SAVE("INSERT INTO anime_store.public.anime (name, episodes, producer_id) VALUES (?, ?, ?)"),
    FIND_BY_NAME_AND_INNER_JOIN_WITH_PRODUCER("""
            SELECT
                a.id,
                a.name,
                a.episodes,
                a.producer_id,
                p.name AS producer_name
            FROM
                anime_store.public.anime a
            INNER JOIN anime_store.public.producer p ON
                a.producer_id = p.id
            WHERE
                a.name LIKE ?"""),
    FIND_BY_ID_AND_INNER_JOIN_WITH_PRODUCER("""
            SELECT
                a.id,
                a.name,
                a.episodes,
                a.producer_id,
                p.name AS producer_name
            FROM
                anime_store.public.anime a
            INNER JOIN anime_store.public.producer p ON
                a.producer_id = p.id
            WHERE
                a.id = ?"""),
    DELETE("DELETE FROM anime_store.public.anime WHERE id = ?"),
    UPDATE("UPDATE anime_store.public.anime SET name = ?, episodes = ? WHERE id = ?");

    public final String SQL;

    AnimeQuery(String sql) {
        this.SQL = sql;
    }
}

enum AnimeErrorMessage {
    ON_SAVE("Error while trying to save anime '{}'"),
    ON_FIND("Error while trying to retrieve one or all animes"),
    ON_UPDATE("Error while trying to update anime '{}'"),
    ON_DELETE("Error while trying to delete anime '{}'");

    public final String MESSAGE;

    AnimeErrorMessage(String message) {
        this.MESSAGE = message;
    }
}