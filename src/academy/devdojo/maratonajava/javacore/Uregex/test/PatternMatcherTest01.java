package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
    public static void main(String[] args) {
        /*
         * Regex ou Regular Expressions, nada mais é do que uma linguagem que foi desenvolvida, que utiliza
         * metacaracteres para encontrar padrões em textos
         * */
        String regex = "aba";
//        String text = "abaaba";
        String text2 = "abababa";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text2);
        System.out.println("texto:  " + text2);
        System.out.println("Índice: 0123456789");
        System.out.println("regex " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
        }
    }
}
