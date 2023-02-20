package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.util.Locale;

public class LocaleTest02 {
    public static void main(String[] args) {
        // Retorna a lingua em que o sistema está configurado
        System.out.println(Locale.getDefault());
        // Todas as isos de lingua e pais que são suportadas
        String[] isoLanguages = Locale.getISOLanguages();
        String[] isoCountries = Locale.getISOCountries();
        // Linguas
        for (String isoLanguage : isoLanguages) {
            System.out.print(isoLanguage + " ");
        }
        System.out.println();
        // Paises
        for (String isoCountry : isoCountries) {
            System.out.print(isoCountry + " ");
        }
    }
}
