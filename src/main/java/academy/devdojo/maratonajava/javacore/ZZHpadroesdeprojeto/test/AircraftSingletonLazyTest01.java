package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.domain.AircraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        bookSeat("1A"); // true
        bookSeat("1A"); // false, porque a primeira chamada do método já comprou e estamos compartilhando a mesma instância

        // Reflection (má prática)
        // String.class -> construtor que contém um atributo String
        // Exceções lançadas: NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true); // mudando o construtor privado para public
        // Espaço de memória diferente. Quebrando o singleton
        AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("787-900");
        System.out.println(aircraftSingletonLazy); // ...AircraftSingletonLazy@682a0b20
    }

    private static void bookSeat(String seat) {
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        AircraftSingletonLazy aircraftSingletonLazy = AircraftSingletonLazy.getINSTANCE();
        System.out.println(aircraftSingletonLazy.bookSeat(seat));
    }
}
