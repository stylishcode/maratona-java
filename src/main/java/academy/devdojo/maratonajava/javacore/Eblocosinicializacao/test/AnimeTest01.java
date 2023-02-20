package academy.devdojo.maratonajava.javacore.Eblocosinicializacao.test;

import academy.devdojo.maratonajava.javacore.Eblocosinicializacao.domain.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("One piece");
        for (int episode : anime.getEpisodes()) {
            // break line on 20,40,60 and 80 percent of array
            if (episode == (((anime.getEpisodes().length + 1) * 20) / 100) ||
                episode == (((anime.getEpisodes().length + 1) * 40) / 100) ||
                episode == (((anime.getEpisodes().length + 1) * 60) / 100) ||
                episode == (((anime.getEpisodes().length + 1) * 80) / 100)) {
                System.out.println();
            }
            System.out.print(episode + " ");
        }
    }
}
