package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
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
         * O objetivo é agrupar as lightnovels com preço < 6 em Promotion.UNDER_PROMOTION e os > 6 em
         * Promotion.NORMAL_PRICE. Usando as streams fica dessa forma.
         * */
        Map<Promotion, List<LightNovel>> collect = lightNovels
                .stream()
                .collect(Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE));

        collect.entrySet().forEach(System.out::println);


        /*
         * E por fim agrupar por Category o que obtemos acima, retornando um Map<Category, Map<Promotion, List<LightNovel>>>.
         * */
        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE)));


        collect1.entrySet().forEach(System.out::println);

    }
}
