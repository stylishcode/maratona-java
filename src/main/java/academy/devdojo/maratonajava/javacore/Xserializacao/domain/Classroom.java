package academy.devdojo.maratonajava.javacore.Xserializacao.domain;

public class Classroom {
    private final String name;

    public Classroom(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
