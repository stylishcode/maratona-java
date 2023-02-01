package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferenceTest03 {
    public static void main(String[] args) {
        // ordena lista
        List<String> list = new ArrayList<>(List.of("Rimuru", "Valdora", "Hikimaru"));
        list.sort(String::compareTo);
        System.out.println(list);

        // converte string para inteiro
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        Integer num = numStringToInteger.apply("10");
        System.out.println(num);

        // verifica se um nome existe na lista
        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(list, "Rimuru")); // true
    }
}
