package academy.devdojo.maratonajava.javacore.ZZDoptional.repository;

import academy.devdojo.maratonajava.javacore.ZZDoptional.domain.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    public static List<Manga> mangas = List.of(
            new Manga(1, "Hajime no Ippo", 1409),
            new Manga(2, "One Piece", 1061),
            new Manga(3, "Naruto", 700),
            new Manga(4, "Dragon Ball Z", 325),
            new Manga(5, "Boku no Hero", 337),
            new Manga(6, "Kimetsu no Yaiba", 205),
            new Manga(7, "Shingeki no Kyojin", 139),
            new Manga(8, "Dororo", 19),
            new Manga(9, "Haikyuu", 402),
            new Manga(10, "Cavaleiros do Zodiaco", 110),
            new Manga(11, "Tokyo Revengers", 278),
            new Manga(12, "Spy x Family", 74),
            new Manga(13, "Corpse Party", 47),
            new Manga(14, "Tokyo Ghoul", 143)
    );

    public static Optional<Manga> findByTitle(String title) {
        return findBy(m -> m.getTitle().equals(title));
    }

    public static Optional<Manga> findById(Integer id) {
       return findBy(m -> m.getId().equals(id));
    }

    private static Optional<Manga> findBy(Predicate<Manga> predicate) {
        Manga found = null;
        for (Manga manga : MangaRepository.mangas) {
            if (predicate.test(manga)) {
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }
}
