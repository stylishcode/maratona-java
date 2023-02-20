package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.domain.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReferenceTest04 {
    public static void main(String[] args) {
        // Supplier que retorna a instância de um AnimeComparator
        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;
        AnimeComparators animeComparators1 = newAnimeComparators.get();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime("One piece", 100), new Anime("Naruto", 500)));
        animeList.sort(animeComparators1::compareByEpisodesNonStatic);
        System.out.println(animeList);

        // lambda
        BiFunction<String, Integer, Anime> animeBiFunction = (title, episodes) -> new Anime(title, episodes);
        // method reference (o objeto não é criado aqui, é apenas um method reference para o método new)
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;
        // aqui o objeto é criado
        System.out.println(animeBiFunction2.apply("Hajime no Ippo", 79));
    }
}
