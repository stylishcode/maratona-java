package academy.devdojo.maratonajava.javacore.Gassociacao.domain;

public class Professor {
    private final String name;
    private String researchField;
    private Seminar[] seminaries;

    public Professor(String name) {
        this.name = name;
    }

    public Professor(String name, String researchField) {
        this(name);
        this.researchField = researchField;
    }

    public String getName() {
        return name;
    }

    public String getResearchField() {
        return researchField;
    }

    public Seminar[] getSeminaries() {
        return seminaries;
    }

    public void setSeminaries(Seminar... seminaries) {
        this.seminaries = seminaries;
    }
}