package academy.devdojo.maratonajava.javacore.ZZJcrud.service;


import academy.devdojo.maratonajava.javacore.ZZIjdbc.domain.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public final class ProducerService {
    private static Scanner scanner = new Scanner(System.in);

    public static void buildMenu(int op) {
        switch (op) {
            case 1 -> findByName();
            default -> throw new IllegalArgumentException("Not a valid operation");
        }
    }

    private static void findByName() {
        System.out.print("Type the name or empty to all: ");
        String name = scanner.nextLine();
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size(); i++) {
            System.out.printf("[%d] - %s%n", i, producers.get(i).getName());
        }
    }

}
