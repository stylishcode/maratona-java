package academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain;

public class Person {
    private String name;
    private int age;

    public void print() {
        System.out.println(name);
        System.out.println(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age < 1) {
            System.out.println("Invalid age");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
