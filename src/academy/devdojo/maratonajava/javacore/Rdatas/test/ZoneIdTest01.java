package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class ZoneIdTest01 {
    public static void main(String[] args) {
        /*
        * O Java também oferece suporte a zonas para você trabalhar com datas
        * */

        // Map (chave e valor) do id das zonas
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(shortIds);

        // Zona do sistema operacional
        System.out.println(ZoneId.systemDefault());

        // Obtendo uma zona para trabalhar (zona precisa existir no Map de zone ids)
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);
        // Criando LocalDateTime para trabalhar com a mudança de zona
        LocalDateTime now = LocalDateTime.now();
        // LocalDateTime antes de aplicar a nova zona
        System.out.println(now);
        // Novo ZonedDateTime que aplica a configuração de zona no LocalDateTime mas não no horário
        ZonedDateTime zonedDateTime = now.atZone(tokyoZone);
        System.out.println(zonedDateTime);

        // Isso pode ser replicado para outras classes, como a Instant
        Instant nowInstant = Instant.now();
        // Novo ZonedDateTime que aplica a configuração de zona no Instant, que diferente do LocalDateTime, aplica a mudança de horário
        ZonedDateTime zonedDateTime2 = nowInstant.atZone(tokyoZone);
        System.out.println(zonedDateTime2);

        // Obtendo zonas através do horário (-04:00, -03:00...etc)
        System.out.println(ZoneOffset.MIN); // -18:00 (mínimo de hora que pode ser subtraido de determinado horário)
        System.out.println(ZoneOffset.MAX); // +18:00 (mínimo de hora que pode ser adicionada a determinado horário)

        // Definindo ZoneOffset de -4 horas (fuso horário de Manaus por exemplo)
        ZoneOffset ofsetManaus = ZoneOffset.of("-04:00");
        // Alterando o offset (não altera o horário, apenas o offset)
        OffsetDateTime offsetDateTime = now.atOffset(ofsetManaus);
        System.out.println(offsetDateTime);

        // Exemplo com Instant (altera o horário)
        OffsetDateTime offsetDateTime2 = nowInstant.atOffset(ofsetManaus);
        System.out.println(offsetDateTime2);

        /*
        * Como existem diferentes calendários, é possível trabalhar com eles nesse novo pacote Java time
        * Por exemplo, o calendário Japonês
        * */
        // Como está o calendário japonês atualmente
        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate); // Atualmente é era reiwa
        LocalDate meijiEraLocalDate = LocalDate.of(1900, 2, 1);
        JapaneseDate meijiEra = JapaneseDate.from(meijiEraLocalDate);
        System.out.println(meijiEra);
    }
}
