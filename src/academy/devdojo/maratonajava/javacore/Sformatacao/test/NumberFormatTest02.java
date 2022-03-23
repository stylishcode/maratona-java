package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest02 {
    public static void main(String[] args) {
        /*
         * NumberFormat é uma classe abstrata para trabalhar com a formatação de números e moedas
         * Locale pode ser usado para alterar os padrões de saida com base em lingua e pais
         * */
        Locale localeDefault = Locale.getDefault();
        Locale localeBR = new Locale("pt", "BR");
        // Alguns paises importantes já contém uma constante que se refere ao locale deles
        Locale localeJP = Locale.JAPAN;
        Locale localeIT = Locale.ITALY;
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getCurrencyInstance();
        nfa[1] = NumberFormat.getCurrencyInstance(localeJP);
        nfa[2] = NumberFormat.getCurrencyInstance(localeBR);
        nfa[3] = NumberFormat.getCurrencyInstance(localeIT);

        double value = 1_000.2130;

        for (NumberFormat numberFormat : nfa) {
            // Máximo de casas decimais (Digitos fracionarios (Japão por exemplo, não tem digitos fracionarios))
            System.out.println("Padrão: " + numberFormat.getMaximumFractionDigits());
            // Definindo um máximo de casas decimais (Digitos fracionarios, incluindo o Japão)
            numberFormat.setMaximumFractionDigits(2);
            System.out.println("Alterado: " + numberFormat.getMaximumFractionDigits());
            // Valores
            System.out.println(numberFormat.format(value));
        }

        // Convertendo valor String para númerico
        String stringValue = "￥1000.2130";
        /*
        * A conversão de moedas (currency) utiliza o mesmo método parse dos números
        * Porém a conversão de moedas é diferente da conversão de número
        * A conversão a ser feita é a da moeda
        * Ex: "1_000.2130" (erro, valor númerico e não moeda)
        * Ex2: "$1_000.2130" (executa, porém quebra em 1 devido ao caractere _)
        * Ex3: "$1000.2130" (correto)
        * Obs: Se você quer converter um valor String japonês por exemplo, você precisa trabalhar com a moeda
        * japonesa
        * Ex: "$1000.2130" string convertido para valor moeda japonesa (erro)
        * Ex2: "￥1000.2130" string convertido para valor moeda japonesa (correto)
        * */
        try {
            System.out.println("Valor convertido: " + nfa[1].parse(stringValue)); // 1 (devido ao _ encontrado)
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*
        * Na vida real, o banco de dados não guarda o valor monetário (ex.: $1000.2130) e sim o númerico (1000.2130)
        * E depois baseado no que deve ser imprimido na tela (ex.:$1000.2130 ou ￥1000.2130), que é adicionada
        * a localização
        * */
    }
}
