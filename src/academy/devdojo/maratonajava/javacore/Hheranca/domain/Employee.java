package academy.devdojo.maratonajava.javacore.Hheranca.domain;

public class Employee extends Person {
    private double salary;

    public void print() {
        super.print();
        System.out.println(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
