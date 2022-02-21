package academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain;

public class Employee {
    public String name;
    public String age;
    public double[] salaries;

    public void showSalaries() {
        if (salaries == null) {
            return;
        }
        for (double salary : this.salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    public void showSalaryAverage() {
        if (salaries == null) {
            return;
        }
        double sum = 0.0, average = 0.0;
        for (double salary : salaries) {
            sum += salary;
        }
        average = sum / salaries.length;
        System.out.println("Salary average: " + average);
    }

    public void showData() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        if (salaries != null) {
            System.out.print("Salary: ");
        }
        showSalaries();
        showSalaryAverage();
    }
}
