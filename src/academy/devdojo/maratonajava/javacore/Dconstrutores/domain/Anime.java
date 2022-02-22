package academy.devdojo.maratonajava.javacore.Dconstrutores.domain;

public class Anime {
    private String name;
    private String type;
    private int episodes;
    private String genre;

    public Anime() {}

    public Anime(String name, String type, int episodes, String genre) {
        this.name = name;
        this.type = type;
        this.episodes = episodes;
        this.genre =  genre;
    }

    public void print() {
        System.out.println(this.name);
        System.out.println(this.type);
        System.out.println(this.episodes);
        System.out.println(this.genre);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}