package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Levi Ackerman");
        employee.setAge("25");
        employee.setSalaries(new double[] {2345.56, 3478.65, 4768.98});
        employee.showData();
    }
}
