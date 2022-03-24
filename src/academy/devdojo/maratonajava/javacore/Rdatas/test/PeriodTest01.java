package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest01 {
    public static void main(String[] args) {
        /*
        * Period é uma classe para trabalhar com datas (date-based)
        * Ela aceita somente LocalDate
        * */
        final LocalDate now = LocalDate.now();
        final LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(7);
        // Periodo entre agora para daqui a dois anos
        // Y -> Years e D -> Days
        final Period p1 = Period.between(now, nowAfterTwoYears);
        // Periodo de 10 dias (Retorna a mesma quantidade passada como argumento, já que trabalha com dias
        final Period p2 = Period.ofDays(10);
        // Periodo de 58 semanas (Retorna em dias, já que não trabalha com semanas)
        final Period p3 = Period.ofWeeks(58);
        // Periodo de 3 meses (Retorna a mesma quantidade passada como argumento, já que também trabalha com meses
        final Period p4 = Period.ofMonths(3);
        // Periodo de 5 anos (Retorna a mesma quantidade passada como argumento, já que também trabalha com anos
        final Period p5 = Period.ofYears(5);
        System.out.println(p1); // P2Y7D
        System.out.println(p2); // P10D
        System.out.println(p3); // P406D
        System.out.println(p4); // P3M
        System.out.println(p5); // P5Y
        /*
        * Um problema dessa classe é que ela não converte por exemplo 15 meses em 1 ano e 3 meses, ou 70 dias
        * em 2 meses e 10 dias, 15 meses é 15 meses e 70 dias é 70 dias
        * */
        System.out.println(p3.getMonths()); // 0 meses sendo que p3 contém 406D??? Problema da classe
        // Tentando obter os meses com um workaround
        System.out.println(Period.between(now, now.plusDays(p3.getDays())).getMonths()); // 1? Não funcionou
        /*
        * É possível obter os meses usando ChronoUnit
        * */
        System.out.println(now.until(now.plusDays(p3.getDays()), ChronoUnit.MONTHS));
    }
}
