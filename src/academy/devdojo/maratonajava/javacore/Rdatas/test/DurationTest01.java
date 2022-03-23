package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationTest01 {
    public static void main(String[] args) {
        /*
         * Duration é uma classe criada para trabalhar com a quantidade de tempo (time-based)
         * Geralmente usada para obter um intervalo entre duas datas (quantas horas,
         * quantos minutos, quantos dias, quantos anos passaram) e ela é baseada em
         * segundos e nanossegundos, ou seja, se a classe utilizada não oferecer suporte
         * a segundos e nanossegundos (ex.: LocalDate), Duration não pode ser usada. Uma classe
         * equivalente a Duration é a Period, que trabalha com datas (date-based)
         * */
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2);
        final LocalTime timeNow = LocalTime.now();
        final LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);
        final Duration d1 = Duration.between(now, nowAfterTwoYears);
        final Duration d2 = Duration.between(timeNow, timeMinus7Hours);
        final Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
        final Duration d4 = Duration.ofDays(20);
        final Duration d5 = Duration.ofMinutes(120);
        /*
        * P -> P é o designador de duração (referido como "período") e é sempre colocado no início da duração.
        * T -> T é o designador de tempo e é sempre colocado no ínicio da representação da hora do dia
        * */
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
    }
}
