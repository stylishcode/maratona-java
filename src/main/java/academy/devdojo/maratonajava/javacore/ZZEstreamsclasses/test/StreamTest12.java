package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
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
        // objetivo: ordenar as lightnovels em um Map por categoria
        // sem streams
        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();

        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()) {
                case FANTASY -> fantasy.add(lightNovel);
                case DRAMA -> drama.add(lightNovel);
                case ROMANCE -> romance.add(lightNovel);
            }
        }

        categoryLightNovelMap.put(Category.FANTASY, fantasy);
        categoryLightNovelMap.put(Category.DRAMA, drama);
        categoryLightNovelMap.put(Category.ROMANCE, romance);

        for (Map.Entry<Category, List<LightNovel>> categoryListEntry : categoryLightNovelMap.entrySet()) {
            System.out.println(categoryListEntry);
        }

        // com streams
        Map<Category, List<LightNovel>> categoryListMap = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory));

        for (Map.Entry<Category, List<LightNovel>> categoryListEntry : categoryListMap.entrySet()) {
            System.out.println(categoryListEntry);
        }


    }
}
