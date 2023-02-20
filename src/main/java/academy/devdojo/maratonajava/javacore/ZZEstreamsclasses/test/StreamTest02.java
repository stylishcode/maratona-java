package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 1. Order LightNove by title
// 2. Retrieve the first 3 title light novels with price less than 4
public class StreamTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shitara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Full Metal Alchemist", 5.99),
            new LightNovel("Kumo desu ga, Nani ka?", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        // Order lightnovels by title

        // Retrieve the first 3 light novels with price less than 4
        // functional form
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getTitle)
                .toList();

        System.out.println(titles);
    }
}
