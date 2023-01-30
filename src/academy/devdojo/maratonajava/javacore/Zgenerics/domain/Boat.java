package academy.devdojo.maratonajava.javacore.Zgenerics.domain;

public class Boat {
    private String name;

    public Boat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "name='" + name + '\'' +
                '}';
    }
}
