package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.domain.AircraftSingletonEnum;

public class AircraftSingletonEnumTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat) {
        // como agora não tem como ver o espaço em memória criado, usamos o hashCode para ver se são iguais
        System.out.println(AircraftSingletonEnum.INSTANCE.hashCode());
        AircraftSingletonEnum instance = AircraftSingletonEnum.INSTANCE;
        System.out.println(instance.bookSeat(seat));
    }
}
