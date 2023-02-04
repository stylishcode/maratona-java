package academy.devdojo.maratonajava.javacore.ZZDoptional.domain;

public class Manga {
    private final Integer id;
    private String title;
    private int chapters;

    public Manga(Integer id, String name, int chapters) {
        this.id = id;
        this.title = name;
        this.chapters = chapters;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", chapters=" + chapters +
                '}';
    }

}
