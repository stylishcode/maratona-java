package academy.devdojo.maratonajava.javacore.ZZKjunit.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeveloperTest {
    @Test
    void instanceOf_ExecutesChildClassMethod_WhenObjectIsChildType() {
        Employee employeeDeveloper = new Developer("1", "Java");
        if (employeeDeveloper instanceof Developer developer) {
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }
    }
}