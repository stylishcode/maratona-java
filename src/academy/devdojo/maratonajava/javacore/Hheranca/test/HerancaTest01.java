package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.domain.Address;
import academy.devdojo.maratonajava.javacore.Hheranca.domain.Employee;
import academy.devdojo.maratonajava.javacore.Hheranca.domain.Person;

public class HerancaTest01 {
    public static void main(String[] args) {
        Address address = new Address();
        address.setStreet("Rua 3");
        address.setCep("012345-209");
        Person person = new Person("Kamogawa");
        person.setCpf("012.345.678-90");
        person.setAddress(address);
        person.print();

        Employee employee = new Employee("Makunouchi Ippo");
        employee.setCpf("067.123.546-76");
        employee.setAddress(address);
        employee.setSalary(4567.87);
        System.out.println("----------------");
        employee.print();

        employee.paymentReport();
    }
}
