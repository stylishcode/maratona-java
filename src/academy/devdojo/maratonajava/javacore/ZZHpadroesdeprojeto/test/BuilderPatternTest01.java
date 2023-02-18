package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.domain.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Person person = Person.PersonBuilder
                .builder()
                .firstName("Luciana")
                .lastName("dev")
                .username("luinha")
                .email("luciana.dev@mail.com")
                .build();

        System.out.println(person);
    }
}
