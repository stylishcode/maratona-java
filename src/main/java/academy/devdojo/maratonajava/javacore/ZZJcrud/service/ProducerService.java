package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

import java.util.Optional;
import java.util.Scanner;

public final class ProducerService {
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
        ProducerRepository.findByName(name)
                .forEach(p -> System.out.printf("%d - %s%n", p.getId(), p.getName()));
    }

    private static void delete() {
        findByName();
        System.out.print("Type the id of the producer you want to delete: ");
        long id = Long.parseLong(SCANNER.nextLine());
        if (id <= 0) throw new IllegalArgumentException("Invalid id");
        System.out.print("Are you sure? Y/N: ");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            ProducerRepository.delete(id);
        }
    }

    public static void save() {
        System.out.print("Type the name of the producer: ");
        String name = SCANNER.nextLine().trim();
        if (name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }

    public static void update() {
        System.out.print("Type the id of the producer you want to update: ");
        Optional<Producer> producerOptional = ProducerRepository.findById(Long.parseLong(SCANNER.nextLine()));
        if (producerOptional.isEmpty()) {
            System.out.println("Producer not found");
            return;
        }
        Producer producerFound = producerOptional.get();
        System.out.println("Producer found: " + producerFound);
        System.out.print("Type the new name or enter to keep the same: ");
        String name = SCANNER.nextLine();
        name = name.isBlank() ? producerFound.getName() : name;
        Producer producer = Producer.builder().id(producerFound.getId()).name(name).build();
        ProducerRepository.update(producer);
    }
}
