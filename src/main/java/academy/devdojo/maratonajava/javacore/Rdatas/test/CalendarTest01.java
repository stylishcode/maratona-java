package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        /*
         * Calendar veio depois da classe Date para resolver os problemas de internacionalização (Ponto em
         * que o Java se esforça para ser bem feito)
         *
         * Calendar é uma classe estática, ou seja, diferente de Date, não pode ser instanciada com o operador new
         * Para obter uma instância de Calendar, utilize o método getInstance()
         *
         * Se Calendar tiver campos em comum com Date, você pode usar Date para formatar a saida dos campos de
         * Calendar
         *
         * */
        Calendar calendar = Calendar.getInstance();
        // Obtendo o 1º dia da semana (Domingo não é o primeiro dia da semana para todos os paises, ex: França)
        if (calendar.getFirstDayOfWeek() == Calendar.SUNDAY) {
            System.out.println("Domingo é o primeiro dia da semana");
        }
        // Obtendo dia da semana, dia da semana no mês, dia do ano, dia da semana no mês
        System.out.println("Dia da semana: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Dia do mês: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Dia do ano: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Dia da semana no mês: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        // Adicionando mais 2 dias e mais 2h na data (add pode virar as datas se o valor passado for alto)
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        calendar.add(Calendar.HOUR, 2);
        // Para continuar na mesma data, só adicionando mais tempo, use o método roll
        calendar.roll(Calendar.HOUR, 12);
        Date date = calendar.getTime();
        System.out.println(date);
    }
}
