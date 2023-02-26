package academy.devdojo.maratonajava.javacore.ZZJcrud.service;


import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public final class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            default -> throw new IllegalArgumentException("Not a valid operation");
        }
    }

    private static void findByName() {
        System.out.print("Type the name or empty to all: ");
        String name = SCANNER.nextLine();
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size(); i++) {
            Producer producer = producers.get(i);
            System.out.printf("[%d] - %d | %s%n", i, producer.getId(), producer.getName());
        }
    }

    private static void delete() {
        findByName();
        System.out.print("Type the id of the producer you want to delete: ");
        long id = Long.parseLong(SCANNER.nextLine());
        if (id <= 0) throw new IllegalArgumentException("Invalid id");
        System.out.print("Are you sure? Y/N: ");
        String choice = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(choice)) {
            ProducerRepository.delete(id);
        }
    }

}
