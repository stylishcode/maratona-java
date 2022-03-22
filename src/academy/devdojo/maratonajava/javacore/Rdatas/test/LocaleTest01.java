package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {
    public static void main(String[] args) {
        /*
        * Classe que permite trabalhar com diversos tipos de formatação
        * Ela segue o padrão de duas ISOS: ISO 639 para as linguas e a ISO 3166 para os paises
        * https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
        * https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes
        * O construtor pode receber a lingua (no padrão iso acima), o pais (também no padrão iso acima) e uma variante
        * Essas localizações podem ser usadas em diversos tipos de classes (como NumberFormat), mas aqui será usado em DateFormat
        * Ex: Italiano falado na própria Itália e o Italiano falado na Suiça (código abaixo) e outros exemplos
        * */

        Locale localeItaly = new Locale("it", "IT");
        Locale localeSwitzerland = new Locale("it", "CH");
        Locale localeIndia = new Locale("hi", "IN");
        Locale localeJapan = new Locale("ja", "JP"); // Pode ser instável
        Locale localeNetherlands = new Locale("nl", "NL");
        Locale localeBrazil = new Locale("pt", "BR");

        Calendar calendar = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeSwitzerland);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localeJapan);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL, localeNetherlands);
        DateFormat df6 = DateFormat.getDateInstance(DateFormat.FULL, localeBrazil);

        System.out.println("Itália: " + df1.format(calendar.getTime()));
        System.out.println("Suíça: " + df2.format(calendar.getTime()));
        System.out.println("Índia: " + df3.format(calendar.getTime()));
        System.out.println("Japão: " + df4.format(calendar.getTime()));
        System.out.println("Holanda: " + df5.format(calendar.getTime()));
        System.out.println("Brasil: " + df6.format(calendar.getTime()));

        // Alguns labels (nome do país do local é exibido) são traduzidos
        System.out.println(localeItaly.getDisplayCountry());
        System.out.println(localeSwitzerland.getDisplayCountry());
        // Podemos passar outro locale pra traduzir labels
        System.out.println(localeItaly.getDisplayCountry(localeJapan));
        System.out.println(localeSwitzerland.getDisplayCountry(localeNetherlands));
        // Como fala "italiano" em japônes
        System.out.println(localeItaly.getDisplayLanguage(localeJapan));
    }
}
