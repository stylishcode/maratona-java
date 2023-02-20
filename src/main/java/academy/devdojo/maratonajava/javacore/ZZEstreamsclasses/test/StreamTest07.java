package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import java.util.List;
import java.util.Optional;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 6, 4, 5);
        // Se um valor inicial não for passado retorna um Optional, caso contrário retorna um Integer
        // forma 1
        Optional<Integer> forma1 = integers.stream().reduce((curr, acc) -> acc + curr);
        forma1.ifPresent(System.out::println);
        // forma 2, passando um valor inicial
        Integer forma2 = integers.stream().reduce(0, (acc, curr) -> acc + curr);
        System.out.println(forma2); // 21
        // forma 3, valor inicial e method reference
        Integer forma3 = integers.stream().reduce(0, Integer::sum);
        System.out.println(forma3);
        // forma 4
        System.out.println(integers.stream().reduce(1, (x, y) -> x * y));

        // retornando o maior valor
        // forma 1
        System.out.println(integers.stream().reduce(0, (a, b) -> a > b ? a : b));
        // forma 2
        System.out.println(integers.stream().reduce(0, Integer::max));
    }
}
