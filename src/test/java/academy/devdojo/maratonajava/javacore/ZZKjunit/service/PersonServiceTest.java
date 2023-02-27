package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import academy.devdojo.maratonajava.javacore.ZZKjunit.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private List<Person> personList;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
        personList = List.of(new Person(17), new Person(18), new Person(21));
    }

    @Test
    @DisplayName("A person should not be adult when age is lower than 18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Assertions.assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equal than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualThan18() {
        Assertions.assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException with message when person is null")
    void isAdult_ThrowException_WhenPersonIsNull() {
       Assertions.assertThrows(IllegalArgumentException.class, () -> personService.isAdult(null), "Person can't be null");
    }

    @Test
    @DisplayName("Should return a list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size());
    }
}