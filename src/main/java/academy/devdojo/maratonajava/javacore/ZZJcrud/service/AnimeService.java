package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.domain.Anime;
import academy.devdojo.maratonajava.javacore.ZZJcrud.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.AnimeRepository;

import java.util.Optional;
import java.util.Scanner;

public final class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
            default -> throw new IllegalArgumentException("Not a valid operation");
        }
    }

    private static void findByName() {
        System.out.print("Type the name or empty to all: ");
        String name = SCANNER.nextLine();
        AnimeRepository.findByName(name)
                .forEach(p -> System.out.printf("%d - %s: %d episodes; made by %s%n", p.getId(), p.getName(),
                        p.getEpisodes(), p.getProducer().getName()));
    }

    private static void delete() {
        findByName();
        System.out.print("Type the id of the anime you want to delete: ");
        long id = Long.parseLong(SCANNER.nextLine());
        if (id <= 0) throw new IllegalArgumentException("Invalid id");
        System.out.print("Are you sure? Y/N: ");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            AnimeRepository.delete(id);
        }
    }

    public static void save() {
        System.out.print("Type the name of the anime: ");
        String name = SCANNER.nextLine().trim();
        if (name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");

        System.out.print("Type the number of episodes: ");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        if (episodes < 0) throw new IllegalArgumentException("Invalid number of episodes");

        System.out.println("Type the id of the producer");
        long producerId = Long.parseLong(SCANNER.nextLine());

        Anime anime = Anime
                .builder()
                .name(name)
                .episodes(episodes)
                .producer(Producer.builder().id(producerId).build())
                .build();
        AnimeRepository.save(anime);
    }

    public static void update() {
        System.out.print("Type the id of the anime you want to update: ");
        Optional<Anime> animeOptional = AnimeRepository.findById(Long.parseLong(SCANNER.nextLine()));
        if (animeOptional.isEmpty()) {
            System.out.println("Anime not found");
            return;
        }
        Anime animeFound = animeOptional.get();
        System.out.println("Anime found: " + animeFound);
        System.out.print("Type the new name or enter to keep the same: ");
        String name = SCANNER.nextLine();
        name = name.isBlank() ? animeFound.getName() : name;

        System.out.print("Type the new number of episodes: ");
        int episodes = Integer.parseInt(SCANNER.nextLine());

        Anime anime = Anime
                .builder()
                .id(animeFound.getId())
                .name(name)
                .episodes(episodes)
                .producer(animeFound.getProducer())
                .build();
        AnimeRepository.update(anime);
    }
}
