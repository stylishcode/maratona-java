package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
        /*
         * Essa classe é a responsável atualmente pelas formatações em Java
         * É importante Lembrar quando se está trabalhando com formatação, é que todas
         * as vezes que for vista a palavra "format", significa que o Objeto trabalhado está
         * sendo transformado em String e todas as vezes que for vista a palavra "parse",
         * significa que a String trabalhada está sendo transformada em Objeto
         * */
        // Format Objeto -> String
        LocalDate date = LocalDate.now();
        String basicIsoDateFormat = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String isoDateFormat = date.format(DateTimeFormatter.ISO_DATE);
        String defaultLocalDateFormat = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(basicIsoDateFormat); // 20220325
        System.out.println(isoDateFormat); // 2022-03-25+01:00 (se tiver offset)
        System.out.println(defaultLocalDateFormat); // 2022-03-25 ou 2022-03-25

        /*
         * Parse String -> Objeto (é necessário a String dar match com o padrão para qual ela vai ser convertida)
         * Ex.: LocalDate.parse("20220325"); -> Erro (não sabe qual padrão usar para converter pra Objeto)
         * Ex2.: LocalDate.parse("20220325", DateTimeFormatter.ISO_DATE); -> Erro (padrão incompativel)
         * Ex3.: LocalDate.parse("20220325", DateTimeFormatter.BASIC_ISO_DATE); -> Correto
         */
        LocalDate parsedBasicIsoDateToLocalDate = LocalDate.parse("20220325", DateTimeFormatter.BASIC_ISO_DATE);
        /*
         * Ele aceita a conversão com esse +01:00 porque ISO_DATE oferece suporte
         * para offset porem não sera exibido em LocalDate porque LocalDate não oferece suporte a offset
         */
        LocalDate parsedIsoDateToLocalDate = LocalDate.parse("2022-03-25+01:00", DateTimeFormatter.ISO_DATE);
        LocalDate redundantParseIsoLocalDateToLocalDate = LocalDate.parse("2022-03-25", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parsedBasicIsoDateToLocalDate); // 2022-03-25
        System.out.println(parsedIsoDateToLocalDate); // 2022-03-25
        System.out.println(redundantParseIsoLocalDateToLocalDate); // 2022-03-25

        // Usando LocalDateTime
        // Convertendo Objeto -> String
        LocalDateTime now = LocalDateTime.now();
        // Trás a data com offset (se existir) e zona (se existir)
        String IsoDateTimeFormat = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(IsoDateTimeFormat); // 2022-03-25T03:16:55.111448

        // Convertendo String -> Objeto
        LocalDateTime redundantParseIsoDateTimeToLocalDateTime = LocalDateTime
                .parse("2022-03-25T03:16:55.111448", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(redundantParseIsoDateTimeToLocalDateTime);

        // Formatações personalizadas como dd/MM/yyyy (BRASIL), MM/dd/yyyy (EUA) ou yyyy/MM/dd (japão)
        DateTimeFormatter brasilFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter euaFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter japanFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // Convertendo Objeto -> String
        String brFormat = LocalDateTime.now().format(brasilFormatter);
        String euaFormat = LocalDateTime.now().format(euaFormatter);
        String japanFormat = LocalDateTime.now().format(japanFormatter);

        System.out.println(brFormat); // 25/03/2022
        System.out.println(euaFormat); // 03/25/2022
        System.out.println(japanFormat); // 2022/03/25

        // Convertendo String -> Objeto
        LocalDate parsedBrasilToLocalDateTime = LocalDate.parse("25/03/2022", brasilFormatter);
        LocalDate parsedEuaToLocalDateTime = LocalDate.parse("03/25/2022", euaFormatter);
        LocalDate parsedJapanToLocalDateTime = LocalDate.parse("2022/03/25", japanFormatter);

        System.out.println(parsedBrasilToLocalDateTime); // 2022-03-25
        System.out.println(parsedEuaToLocalDateTime); // 2022-03-25
        System.out.println(parsedJapanToLocalDateTime); // 2022-03-25

        // Format usando locale
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        String germanFormat = LocalDate.now().format(germanFormatter);
        System.out.println(germanFormat); // 25.März.2022

        // Parse usando locale
        LocalDate parsedGermanFormatToLocalDate = LocalDate.parse("25.März.2022", germanFormatter);
        System.out.println(parsedGermanFormatToLocalDate); // 2022-03-25

    }
}
