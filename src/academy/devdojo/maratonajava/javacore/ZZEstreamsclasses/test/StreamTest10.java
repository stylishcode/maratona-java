package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        // Podemos criar streams "infinitas" usando os métodos Stream.iterate e Stream.generate
        /*
         * iterate recebe um seed inicial de tipo T (por exemplo, se estamos trabalhando com valores numéricos,
         * podemos dizer que é 1
         * O segundo parametro é um UnaryOperator que é uma interface funcional que retorna o que ela recebe como argumento,
         * por exemplo, se é passado T, ele vai retornar o próprio T
         */
        // gerando números impares infinitamente
        // Stream.iterate(1, n -> n + 2)
        //      .forEach(System.out::println);
        // gerando 100 números impares
        Stream.iterate(1, n -> n + 2)
                .limit(100)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // série de fibonacci em array de pares
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEach(a -> System.out.println(Arrays.toString(a)));

       // série de fibonacci valor atual
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);

        /*
        * Generate recebe um supplier
        * Vamos criar uma stream que gera 10 valores aleatórios
        * */
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1, 50000))
                .limit(90)
                .forEach(System.out::println);

    }
}
