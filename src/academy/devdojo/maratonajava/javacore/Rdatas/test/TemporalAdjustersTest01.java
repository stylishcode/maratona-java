package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        /*
        * As vezes você quer adicionar dias, por exemplo now.plusDays(2), ok, dia 26
        * Mas isso não funciona para mudar o dia, por exemplo, now.plusDays(20), vai virar o mês
        * Nesse caso você pode usar o método with pra fazer um "replace" do campo e não adição de mais
        * tempo nesses campos
        * Ex plusDays.: 26/12/1997 -> now.plusDays(2) -> 28/12/1997
        * Ex with.: 26/12/1997 -> now.withDayOfMonth(2) -> 02/12/1997
        * */
        LocalDate now = LocalDate.now();
//        now = now.withDayOfMonth(20);
        now = now.with(ChronoField.DAY_OF_MONTH, 18);
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Saber quando é a próxima quinta-feira usando TemporalAdjusters
        now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        System.out.println("A próxima " + now.getDayOfWeek() + " será em: " + now);

        // Saber quando foi a última quinta-feira usando TemporalAdjusters
        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
        System.out.println("A última " + now.getDayOfWeek() + " foi em: " + now);

        // Saber o primeiro dia do mês usando TemporalAdjusters
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("O primeiro dia desse mês foi " + now.getDayOfWeek() + " em: " + now);

        // Saber o último dia do mês usando TemporalAdjusters
        now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("O último dia desse mês será " + now.getDayOfWeek() + " em: " + now);

        // Saber o primeiro dia do próximo ano usando TemporalAdjusters
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("O primeiro dia do próximo ano será " + now.getDayOfWeek() + " em: " + now);

        // Saber o primeiro dia do próximo mês usando TemporalAdjusters
        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("O primeiro dia do próximo mês será " + now.getDayOfWeek() + " em: " + now);
    }
}
