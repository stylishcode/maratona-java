package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {

    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(new LightNovel("Tensei Shitara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Full Metal Alchemist", 5.99),
            new LightNovel("Kumo desu ga, Nani ka?", 1.99),
            new LightNovel("Kumo desu ga, Nani ka?", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));
    public static void main(String[] args) {
        // summarizing (resumo de informações)

        // contagem de elementos com o método count
        // a ide sugere trocar isso por (long) Collection.size(), porque é mais leve do que usar uma stream só pra isso
        System.out.println(lightNovels.stream().count());
        // contagem de elementos com Collectors.counting()
        // novamente a ide recomenda a troca pelo Stream.count(), que recomenda (long) Collection.size()
        System.out.println(lightNovels.stream().collect(Collectors.counting()));

        // comparação com o método Stream.max()
        lightNovels.stream().max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);
        // comparação com Collectors.maxBy()
        // a ide sugere trocar isso por Stream.max()
        lightNovels.stream()
                .collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)))
                .ifPresent(System.out::println);

        // soma dos preços com Stream.mapToDouble().sum()
        System.out.println(lightNovels.stream().mapToDouble(LightNovel::getPrice).sum());
        // soma dos preços com Collectors.summingDouble()
        // a ide sugere trocar por Stream.mapToDouble().sum()
        System.out.println(lightNovels.stream().collect(Collectors.summingDouble(LightNovel::getPrice)));

        // média dos preços com Stream.mapToDouble().average()
        lightNovels.stream().mapToDouble(LightNovel::getPrice).average().ifPresent(System.out::println);
        // média dos preços com Collectors.averagingDouble()
        System.out.println(lightNovels.stream().collect(Collectors.averagingDouble(LightNovel::getPrice)));

        // resumo geral (summarizing)
        DoubleSummaryStatistics priceStatistics = lightNovels.stream()
                .collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(priceStatistics);
        // DoubleSummaryStatistics{count=8, sum=35.930000, min=1.990000, average=4.491250, max=8.990000}

        // Juntando todos os titulos das lightnovels por virgula
        // Leva em consideração não colocar , se já for o ultimo elemento
        String titles= lightNovels.stream().map(LightNovel::getTitle).collect(Collectors.joining(", "));
        System.out.println(titles);
    }
}
