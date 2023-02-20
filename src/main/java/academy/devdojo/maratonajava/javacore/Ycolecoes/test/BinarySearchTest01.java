package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(0);
        numbers.add(4);
        numbers.add(3);

        /*
         * retorna (-(ponto de inserção) - 1) quando não encontra o elemento
         * -1 para diferenciar caso seja um índice existente ou posição a ser inserida
         * Ou seja, é a garantia de que ele só vai retornar um valor positivo se e
         * somente se o elemento procurado existir. Com isso em mente, sabemos que
         * não se pode ter elementos negativos na lista
         */
        Collections.sort(numbers);
        System.out.println(Collections.binarySearch(numbers, 2)); // 1
        System.out.println(Collections.binarySearch(numbers, 1));
    }
}
