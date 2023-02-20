package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
    public static void main(String[] args) {
        // obter os processadores virtuais disponiveis para as parallels streams usar
        System.out.println(Runtime.getRuntime().availableProcessors());

        long num = 10_000_000;

        sumFor(num);
        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        sumLongStreamIterate(num);
        sumLongStreamParallelIterate(num);
    }

    // métodos para analise de tempo para realizar a mesma operação (somar numeros milhões de vezes)
    private static void sumFor(long num) {
        System.out.println("sumFor");
        long result = 0;
        long init = System.currentTimeMillis();
        for (int i = 0; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumStreamIterate(long num) {
        System.out.println("sumStreamIterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    // parallel streams: permite que multiplas threads trabalhem em uma stream
    // thread 1 pode somar de 1 a 5
    // thread 2 pode somar de 6 a 0
    // acima é apenas um exemplo simples, não necessariamente funciona dessa forma
    // NOTA: ter multiplas threads trabalhando não implica em um menor tempo de execução, pode até ser mais longo
    // NOTA: parallel() pode ir em qualquer lugar da chain method. Ele funciona como uma 'flag'
    private static void sumParallelStreamIterate(long num) {
        System.out.println("sumParallelStreamIterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumLongStreamIterate(long num) {
        System.out.println("sumLongStreamIterate");
        long init = System.currentTimeMillis();
        long result = LongStream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }

    private static void sumLongStreamParallelIterate(long num) {
        System.out.println("sumLongStreamParallelIterate");
        long init = System.currentTimeMillis();
        long result = LongStream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + "ms");
    }
}
