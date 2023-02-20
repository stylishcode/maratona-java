package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.domain.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repository.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        // Procurar por titulo, se existir, atualizar o titulo
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Naruto");
        mangaByTitle.ifPresent(m -> m.setTitle("Naruto Shippuden"));
        System.out.println(mangaByTitle);

        // Procurar por id, se não existir, lançar exceção de tipo IllegalArgumentException
        Manga mangaById = MangaRepository.findById(11)
                .orElseThrow(() -> new IllegalArgumentException("Id não encontrado"));
        System.out.println(mangaById);

        // Procurar por titulo, se não existir, criar um novo Manga
        Manga createMangaIfNotExists = MangaRepository.findByTitle("Golden Time")
                .orElseGet(() -> new Manga(15, "Golden Time", 38));
        System.out.println(createMangaIfNotExists);

    }
}
