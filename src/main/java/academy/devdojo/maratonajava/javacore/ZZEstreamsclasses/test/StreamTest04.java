package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Wilde Suane", "Catarina Santos", "Sandy Carolina");
        List<String> developers = List.of("William", "David", "Harrison");
        List<String> students = List.of("Édipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");
        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

//        for (List<String> people : devdojo) {
//            for (String name : people) {
//                System.out.println(name);
//            }
//        }

//        List<String> people = devdojo.stream()
//                .flatMap(Collection::stream)
//                .toList();
//        people.forEach(System.out::println);
//
        // ou
        devdojo.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}
