package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.Promotion;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamTest15 {
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
        // resumo dos lightnovels por categoria
        Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect);

        // Map por categoria das listas de lightnovels por Promotion
        Map<Category, List<Promotion>> collect1 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, mapping(StreamTest15::getPromotion, toList())));
        System.out.println(collect1);

        // Map por categoria de um Set (HashSet) de lightnovels por Promotion
        Map<Category, Set<Promotion>> collect2 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, mapping(StreamTest15::getPromotion, toSet())));
        System.out.println(collect2);

        // Map por categoria de um Set (LinkedHashSet) de lightnovels por Promotion
        // Diferente do HashSet, esse mantém a ordem de inserção
        Map<Category, LinkedHashSet<Promotion>> collect3 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, mapping(StreamTest15::getPromotion,
                        toCollection(LinkedHashSet::new))));
        System.out.println(collect3);

    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
