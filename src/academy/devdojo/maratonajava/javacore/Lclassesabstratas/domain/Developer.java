package academy.devdojo.maratonajava.javacore.Lclassesabstratas.domain;

public class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public String toString() {
        return "Developer: { " +
                "name='" + name + '\'' + "" +
                ", salary=" + salary + " " +
                '}';
    }
}
