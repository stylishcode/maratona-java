package academy.devdojo.maratonajava.javacore.ZZEstreamsclasses.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {
        // Stream que trabalha com tipos primitivos para manter a alta performance
        // IntStream tem dois método para criar uma stream de inteiros:
        // IntStream.range(int startInclusive, int endExclusive) → De ínicio a fim - 1
        // IntStream.rangeClosed(int startInclusive, int endInclusive) → De inicio a fim

        // Contar de 1 a 50 e imprimir os números pares no console
        IntStream.rangeClosed(1, 50)
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.print(num + " "));
        // 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50
        System.out.println();
        IntStream.range(1, 50)
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.print(num + " "));
        // 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48
        System.out.println();

        // Stream de String, mas pode ser Stream de T value
        Stream.of("Java", "Streams", "is", "Awesome")
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // Stream de array de int
        int[] num = {1, 2, 3, 4, 5};
        Arrays.stream(num)
                .average()
                .ifPresent(System.out::println);

        // Criando o arquivo com o conteúdo
        Path filePath = Path.of("file.txt");
        if (Files.notExists(filePath)) {
            try(FileWriter fw = new FileWriter(filePath.toFile(), true);
                BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write("Java é legal");
                bw.newLine();
                bw.write("Java vai me deixar rico");
                bw.newLine();
                bw.write("Python é ...");
                bw.newLine();
                bw.write("PHP então...");
                bw.newLine();
                bw.write("Oh boy");
                bw.newLine();
                bw.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Obter as linhas que contém Java de um arquivo
        try (Stream<String> lines = Files.lines(filePath)) {
           lines.filter(l -> l.contains("Java"))
                   .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
