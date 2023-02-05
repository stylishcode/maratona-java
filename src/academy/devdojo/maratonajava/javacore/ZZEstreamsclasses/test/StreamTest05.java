package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");

        // forma imperativa
        List<String> letters = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                letters.add(word.split("")[i]);
            }
        }

        System.out.println(letters);

        // forma imperativa 2
        List<String> letters2 = new ArrayList<>();
        for (String word : words) {
            letters2.addAll(Arrays.asList(word.split("")).subList(0, word.length()));
        }

        System.out.println(letters);

        // forma funcional com streams
        List<String> strings = words.stream()
                // Stream<String[]>
                .map(word -> word.split("")) // [ [G, o, m, u], [G, o, m, u], [N, o], [M, i] ]
                // Stream<String>
                .flatMap(Arrays::stream) // Arrays.stream() transforma um array em um stream
                // List<String>
                .collect(Collectors.toList());
        System.out.println(strings);
    }
}
