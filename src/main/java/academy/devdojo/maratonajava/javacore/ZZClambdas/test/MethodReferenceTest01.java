package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.domain.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime("One piece", 100), new Anime("Naruto", 500)));
        // lambda para criar método anônima
        // Collections.sort(animeList, (a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
        // chamada estática a partir da classe com lambda
        // Collections.sort(animeList, (a1, a2) -> AnimeComparators.compareByTitle(a1, a2));
        // Método de referência estático (limpo e prático)
        Collections.sort(animeList, AnimeComparators::compareByTitle);
        System.out.println(animeList);

        Collections.sort(animeList, AnimeComparators::compareByEpisodes);
        System.out.println(animeList);
    }
}
