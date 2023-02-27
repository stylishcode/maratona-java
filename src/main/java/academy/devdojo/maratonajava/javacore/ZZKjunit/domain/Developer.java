package academy.devdojo.maratonajava.javacore.ZZKjunit.domain;

public final class Developer extends Employee {
    private final String mainLanguage;

    public Developer(String id, String mainLanguage) {
        super(id);
        this.mainLanguage = mainLanguage;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }
}
