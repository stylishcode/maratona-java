package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
    public static void main(String[] args) {
        /* Lista de alguns metacaracteres
         * \d = Todos os dígitos
         * \D = Tudo o que não for dígito
         * \s = Todos os espaços em branco (\t \r \f \n)
         * \S = Todos os caracteres, excluindo os brancos
         * \w = a-zA-Z, dígitos, _
         * \W = Tudo o que não for incluso no \w
         * [] = Range de caracteres, ex.: [abcABC] procura por a ou b ou c ou A ou B ou C
         * ex2.: [a-zA-C] de a a z minusculo, A a C maiusculo
         * */
        String regex = "[a-zA-C]";
        String text = "cafeBABE";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Índice: 0123456789");
        System.out.println("texto:  " + text);
        System.out.println("regex " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }
    }
}
