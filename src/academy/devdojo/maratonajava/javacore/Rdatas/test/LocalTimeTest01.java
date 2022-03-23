package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeTest01 {
    public static void main(String[] args) {
//        LocalTime time = LocalTime.of(24, 32, 12); Invalid value for HourOfDay (valid values 0 - 23): 24
        LocalTime time = LocalTime.of(23, 32, 12);
        LocalTime timeNow = LocalTime.now();
        System.out.println(time); // 23:32:12
        System.out.println(timeNow);
        // Hora
        System.out.println(time.getHour());
        // Minuto
        System.out.println(time.getMinute());
        // Segundo
        System.out.println(time.getSecond());
        // Algo mais específico, além dos métodos utilitários
        System.out.println(time.get(ChronoField.HOUR_OF_DAY)); // 23
        // Inicio do dia ao fim do dia
        System.out.println(LocalTime.MIN); // 00:00
        System.out.println(LocalTime.MAX); // 23:59:59.999999999
    }
}
