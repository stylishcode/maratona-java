package academy.devdojo.maratonajava.javacore.Hheranca.domain;

public class Employee extends Person {
    private double salary;

    public void print() {
        super.print();
        System.out.println(salary);
    }

    public void paymentReport() {
        System.out.println("Eu, " + this.name + " recebi o salário de R$ " + this.salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
