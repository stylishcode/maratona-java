package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
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

        double value = 1_000.2130;

        for (NumberFormat numberFormat : nfa) {
            // Máximo de casas decimais (Digitos fracionarios)
            System.out.println(numberFormat.getMaximumFractionDigits());
            // Valores formatados
            System.out.println(numberFormat.format(value));
        }

        // Convertendo valor String para númerico
        String stringValue = "1_000.2130";
        /*
        * Poderiamos converte-lo usando o método parse dos Wrappers Integer, Double e Float e assim por diante
        * Porém vamos tentar converte-lo usando o parse da classe NumberFormat
        * Obs: "O caractere _ é valido na hora de escrever números direto no código, porém não é valido na
        * hora da conversão de String para númerico. Quando o parse encontrar algum caractere inválido, ele
        * encerra a conversão. Ex: 123_456, seria convertido somente para 123"
        * */
        try {
            System.out.println("Valor convertido: " + nfa[0].parse(stringValue)); // 1 (devido ao _ encontrado)
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String anotherStringValue = "1000.2130";
        try {
            System.out.println("Valor convertido 2: " + nfa[0].parse(anotherStringValue)); // 1000.213 (correto)
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
