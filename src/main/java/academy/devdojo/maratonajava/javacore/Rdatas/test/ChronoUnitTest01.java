package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
    public static void main(String[] args) {
        final LocalDateTime birthday = LocalDateTime.of(1997, Month.DECEMBER, 26, 5,50);
        final LocalDateTime now = LocalDateTime.now();
        System.out.println(ChronoUnit.DAYS.between(birthday, now)); // 8853
        System.out.println(ChronoUnit.WEEKS.between(birthday, now)); // 1264
        System.out.println(ChronoUnit.MONTHS.between(birthday, now)); // 290
        System.out.println(ChronoUnit.YEARS.between(birthday, now)); // 24

        /* Relembrando os usos
        * Duration -> para lidar com horas
        * Period -> para lidar com datas
        * Instant -> para lidar com nanossegundos (para computadores)
        * LocalDate -> para lidar com data para leitura humana
        * LocalTime -> para lidar com hora para leitura humana
        * LocalDateTime -> para lidar com data e hora para leitura humana
        * */
    }
}
