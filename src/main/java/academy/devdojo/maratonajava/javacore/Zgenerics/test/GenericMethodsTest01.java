package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Boat;

import java.util.List;

public class GenericMethodsTest01 {
    public static void main(String[] args) {
        List<Boat> canoaMarota = createArrayWithAObject(new Boat("Canoa Marota"));
        System.out.println(canoaMarota);
    }

    private static <T> List<T> createArrayWithAObject(T t) {
        return List.of(t);
    }
}
