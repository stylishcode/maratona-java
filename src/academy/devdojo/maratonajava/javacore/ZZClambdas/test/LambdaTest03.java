package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest03 {
    public static void main(String[] args) {
        List<String> words = List.of("world", "car", "boat", "javascript"); // 5 3 4 10
        // retorna uma lista com o tamanho de cada string
        List<Integer> sizeOfStrings = map(words, s -> s.length());
        System.out.println(sizeOfStrings); // [5, 3, 4, 10]

        // retorna uma lista com todas as strings em caixa alta
        List<String> stringsToUpper = map(words, s -> s.toUpperCase());
        System.out.println(stringsToUpper);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T e : list) {
            R fn = function.apply(e);
            result.add(fn);
        }
        return result;
    }
}
