package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
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
         *
         * Quantificadores
         * ? = Zero ou uma ocorrência
         * * = Zero ou mais ocorrências
         * + = Uma ou mais ocorrências
         * {x,y} = De x até y ocorrências
         *
         * () = agrupamento
         * | = a ou b -> Ex.: o(v|c)o = ovo ou oco
         * $ = fim da linha
         * Exercício: Digamos que você tem um texto e quer encontrar o números hexadecimais válidos, então você
         * sabe que os números hexadecimais válidos tem que começar com 0x e as letras não podem passar de F
         * */

        String text2 = "12 0x 0X 0XFFABC 0x10G 0x1";
        String validHexNumber = "0[xX]([0-9a-fA-F])+(\\s|$)";
        Pattern pattern = Pattern.compile(validHexNumber);
        Matcher matcher = pattern.matcher(text2);
        System.out.println("texto:  " + text2);
        System.out.println("Índice: 0123456789");
        System.out.println("regex " + validHexNumber);
        System.out.println("Posições encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }
    }
}
