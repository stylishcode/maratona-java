package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // Basicamente, LocalDateTime é uma junção de LocalDate com LocalTime, com seus métodos e atributos.. etc
        // É possível converter um valor string para um LocalTime ou LocalDate
        LocalDate date = LocalDate.parse("2022-08-06");
        LocalTime time = LocalTime.parse("09:45:00");
        System.out.println(date);
        System.out.println(time);
        // É possível fazer uma junção entre essas classes
        // Adicionando horario ao dia
        LocalDateTime ldt1 = date.atTime(time);
//        LocalDateTime ldt2 = date.atTime(12, 15, 2);
        // Adicionando dia ao horario
        LocalDateTime ldt3 = time.atDate(date);
        System.out.println(ldt1);
        System.out.println(ldt3);
    }
}
