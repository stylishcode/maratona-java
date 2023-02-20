package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.Employee;
import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.Person;

public class OverrideWithExceptionTest01 {
    public static void main(String[] args) {
        Person person = new Person();
        Employee employee = new Employee();

        employee.save();
    }
}
