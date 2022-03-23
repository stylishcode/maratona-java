package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTest01 {
    public static void main(String[] args) {
        // Data com a classe Date
        System.out.println(new Date());
        // Data com a classe Calendar
        System.out.println(Calendar.getInstance());
        // LocalDate (trabalha apenas com a data, sem horário. Ela foi incluida na versão 8 do Java)
        LocalDate localDate = LocalDate.of(2022, Month.MARCH, 23);
        // Data atual
        LocalDate now = LocalDate.now();
        // Ano
        System.out.println(localDate.getYear()); // 2022
        // Mês e valor do mês
        System.out.println(localDate.getMonth()); // March
        System.out.println(localDate.getMonthValue()); // 3
        // Dia da semana
        System.out.println(localDate.getDayOfWeek()); // 3 (terça)
        // Dia do mês
        System.out.println(localDate.getDayOfMonth()); // 23
        // Tamanho do mês (30, 31, 28...)
        System.out.println(localDate.lengthOfMonth()); // 31
        // Ano bissexto ou não bissexto
        System.out.println(localDate.isLeapYear()); // false
        // Algo mais específico do que os métodos utilitários
        System.out.println(localDate.get(ChronoField.YEAR)); // 2022
        System.out.println(localDate.get(ChronoField.DAY_OF_MONTH)); // 23
        // A saida do localdate é exatamente como ela geralmente é salva no banco de dados
        System.out.println(localDate); // 2022-03-23
        // Data atual
        System.out.println(now);
        // Data máxima e data mínima que pode ser utilizada
        System.out.println(LocalDate.MAX); // +999999999-12-31
        System.out.println(LocalDate.MIN); // -999999999-01-01
        /*
        * A classe LocalDate é imutável (thread-safe), ou seja, se você por exemplo quiser adicionar mais 2 dias
        * a uma data, você precisa fazer da seguinte forma:
        * now.plusDays(2) -> ignorado
        * now = now.plusDays(2) -> correto
        * Isso porque uma classe imutável não é alterável, ela sempre cria um novo objeto
        * */
    }
}
