package academy.devdojo.maratonajava.javacore.Hheranca.domain;

public class Employee extends Person {
    private double salary;

    static {
        System.out.println("Dentro do bloco estático de Employee");
    }

    {
        System.out.println("Dentro do bloco de inicialização de Employee 1");
    }

    {
        System.out.println("Dentro do bloco de inicialização de Employee 2");
    }

    public void print() {
        super.print();
        System.out.println(salary);
    }

    public Employee(String name) {
        super(name);
        System.out.println("Dentro do construtor de employee");
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
