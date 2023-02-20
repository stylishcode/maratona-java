package academy.devdojo.maratonajava.javacore.Gassociacao.domain;

public class Student {
    private final String name;
    private final int age;
    private final Seminar seminar;

    public Student(String name, int idade, Seminar seminary) {
        this.name = name;
        this.age = idade;
        this.seminar = seminary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Seminar getSeminar() {
        return seminar;
    }
}