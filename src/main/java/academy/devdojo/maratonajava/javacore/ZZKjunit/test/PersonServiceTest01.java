package academy.devdojo.maratonajava.javacore.ZZKjunit.test;

import academy.devdojo.maratonajava.javacore.ZZKjunit.domain.Person;
import academy.devdojo.maratonajava.javacore.ZZKjunit.service.PersonService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonServiceTest01 {
    public static void main(String[] args) {
        Person person = new Person(15);
        log.info("Is adult? '{}'", PersonService.isAdult(person));
    }
}
