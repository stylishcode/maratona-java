package academy.devdojo.maratonajava.javacore.Lclassesabstratas.domain;

public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        calculateBonus();
    }
    /*
    * Métodos abstratos só podem existir dentro de classes abstratas
    * Métodos concretos (com corpo e implementação) podem existir tanto em classes concretas quanto abstratas
    * */
    public abstract void calculateBonus();
}
