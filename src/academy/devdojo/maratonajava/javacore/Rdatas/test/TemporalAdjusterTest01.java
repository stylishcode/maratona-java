package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

class GetNextBusinessDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        // dias a adicionar para o prox dia útil
        int daysToAdd;
        switch (dayOfWeek) {
            case THURSDAY:
                daysToAdd = 4;
                break;
            case FRIDAY:
                daysToAdd = 3;
                break;
            case SATURDAY:
                daysToAdd = 2;
                break;
            default:
                daysToAdd = 1;
                break;
        }
        // Retorna os dias adicionados
        return temporal.plus(daysToAdd, ChronoUnit.DAYS);
    }
}

public class TemporalAdjusterTest01 {
    public static void main(String[] args) {
        /*
         * Exercicio: Digamos que sexta, sábado e domingo sejam considerados dias de semana. Dada uma
         * determinada data, você tem que retornar o próximo dia útil. Por exemplo: Segunda, tem que retornar
         * terça, quarta retorna quinta, e quinta (a data inicial) retorna segunda, como sexta tem sábado, que
         * não é util retorna segunda, sábado retorna segunda e domingo também retorna segunda
         * */
        LocalDate now = LocalDate.now();

        // Dia atual
        System.out.print("Hoje é " + now + ", " + now.getDayOfWeek());

        // Próximo dia útil
        now = LocalDate.now().with(new GetNextBusinessDay());
        System.out.println(". O próximo dia útil é em " + now + ", " + now.getDayOfWeek());

        // Qual foi o dia útil a partir do dia 15 desse mês
        now = LocalDate.now().withDayOfMonth(15);
        System.out.print("O dia útil a partir de " + now + ", " + now.getDayOfWeek());
        now = LocalDate.now().withDayOfMonth(15).with(new GetNextBusinessDay());
        System.out.println(", foi " + now + ", " + now.getDayOfWeek());

        // Qual foi o dia útil a partir do dia 27 desse mês
        now = LocalDate.now().withDayOfMonth(27);
        System.out.print("O dia útil a partir de " + now + ", " + now.getDayOfWeek());
        now = LocalDate.now().withDayOfMonth(27).with(new GetNextBusinessDay());
        System.out.println(", será " + now + ", " + now.getDayOfWeek());
    }
}
