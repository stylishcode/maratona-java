package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.LightNovel;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

public class StreamTest14 {
    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shitara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 3.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game No Life", 2.99, Category.FANTASY),
            new LightNovel("Full Metal Alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo desu ga, Nani ka?", 1.99, Category.FANTASY),
            new LightNovel("Kumo desu ga, Nani ka?", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.0, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        /*
         * O objetivo nesse exemplo é contar a quantidade de lightnovels por categoria, depois agrupar por categoria
         * e maior preço.
         */
        // contando quantidade de lightnovels por categoria
        Map<Category, Long> collect = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(collect);

        // agrupando por categoria e maior preço (retorna um Optional)
        Map<Category, Optional<LightNovel>> collect1 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect1);

        // forma 1
        Map<Category, LightNovel> collect2 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        collectingAndThen(maxBy(Comparator.comparing(LightNovel::getPrice)), Optional::get)));
        System.out.println(collect2);

        // intellij recomenda essa forma ao invés da forma 1
        Map<Category, LightNovel> collect3 = lightNovels.stream()
                .collect(Collectors.toMap(
                        LightNovel::getCategory,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))));

        System.out.println(collect3);
    }
}
