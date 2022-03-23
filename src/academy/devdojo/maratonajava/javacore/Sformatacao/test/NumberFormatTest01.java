package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest01 {
    public static void main(String[] args) {
       /*
       * NumberFormat é uma classe abstrata para trabalhar com a formatação de números
       * Locale pode ser usado para alterar os padrões de saida com base em lingua e pais
       * */
        Locale localeDefault = Locale.getDefault();
        Locale localeBR = new Locale("pt", "BR");
        // Alguns paises importantes já contém uma constante que se refere ao locale deles
        Locale localeJP = Locale.JAPAN;
        Locale localeIT = Locale.ITALY;
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getInstance();
        nfa[1] = NumberFormat.getInstance(localeJP);
        nfa[2] = NumberFormat.getInstance(localeBR);
        nfa[3] = NumberFormat.getInstance(localeIT);

        double value = 10_000_000.2130;

        for (NumberFormat numberFormat : nfa) {
            System.out.println(numberFormat.format(value));
        }
    }
}
