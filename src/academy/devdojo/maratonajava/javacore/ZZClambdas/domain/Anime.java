package academy.devdojo.maratonajava.javacore.ZZClambdas.domain;

public class Anime {
    private final String title;
    private final int episodes;

    public Anime(String title, int quantity) {
        this.title = title;
        this.episodes = quantity;
    }

    public String getTitle() {
        return title;
    }

    public int getEpisodes() {
        return episodes;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", episodes=" + episodes +
                '}';
    }
}
