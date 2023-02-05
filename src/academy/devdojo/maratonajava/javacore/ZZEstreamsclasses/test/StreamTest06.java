package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest06 {
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
        // Existe algo que atenda ao critério passado?
        // Nesse exemplo retorna true se existir qualquer preço > 8
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));

        // Todos os elementos atendem ao critério passado?
        // Nesse exemplo retorna true se o preço de todos os elementos da lista forem > 0
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));

        // Nenhum elemento atende ao critério passado?
        // Nesse exemplo retorna true se NENHUM dos elementos da lista tiverem o preço < 0
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0));

        // Qualquer um que encontrar com preço > 3
        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .findAny() // Retorna um optional
                .ifPresent(System.out::println); // LightNovel{title='Tensei Shitara', price=8.99}

        // Primeiro que encontrar com preço < 4
        lightNovels.stream()
                .filter(ln -> ln.getPrice() < 4)
                .findFirst()
                .ifPresent(System.out::println); // LightNovel{title='Overlord', price=3.99}
    }
}
