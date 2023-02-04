package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
    private static final List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shitara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game No Life", 2.99),
            new LightNovel("Full Metal Alchemist", 5.99),
            new LightNovel("Kumo desu ga, Nani ka?", 1.99),
            new LightNovel("Kumo desu ga, Nani ka?", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        // Não é boa prática usar o forEach da stream para imprimir. Desperdicio de recurso (processamento)
        // lightNovels.stream().forEach(System.out::println);
        // List já tem um método forEach que recebe um Consumer que pode realizar uma ação
        lightNovels.forEach(System.out::println);

        // Você pode guardar uma Stream em uma variável
        Stream<LightNovel> lightNovelStream = lightNovels.stream();

        // Tarefa: Obter a quantidade de light novels que tem o preço menor ou igual a 4
        long count = lightNovelStream
                .distinct() // Caso tenha elementos duplicados, ignora o segundo na contagem (equals and hashcode)
                .filter(ln -> ln.getPrice() <= 4)
                .count();
        System.out.println(count);
    }
}
