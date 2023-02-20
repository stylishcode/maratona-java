package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
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
         * . = coringa -> Ex.: 1.3 = 113, 123, 133, 1#3, 1@3 ..etc
         * ^ = Início da linha
         * [^abc] = Tudo as ocorrências que não são abc
         *
         * Exercicio: Encontrar todos os emails validos
         * */

        String regex = "([a-zA-z0-9._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String text = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br, sakura@mail";
        System.out.println("Email valido");
        // valida a string com base na regex
        System.out.println("zoro@mail.br".matches(regex));
        // separa a string por virgula e retorna array
        System.out.println(Arrays.toString(text.split(",")));
        // separa a primeira ocorrencia antes da virgula e remove os espaços antes de depois
        System.out.println(text.split(",")[1].trim());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("texto:  " + text);
        System.out.println("Índice: 0123456789");
        System.out.println("regex " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }
    }
}
