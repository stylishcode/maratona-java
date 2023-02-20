package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrayConversion {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        /**
         * 1ª forma
         * 
         * Segundo um artigo, passar [0] em vez de size() é mais performático
         * Quando passado [0], o Java vai usar o reflection pra descobrir o tamanho
         * do array que ele precisa criar
         */
        Integer[] listToArray = numbers.toArray(new Integer[0]);
        System.out.println(Arrays.toString(listToArray));
        System.out.println("---------------------");

        /**
         * 2ª forma
         */
        Integer[] arrayNumbers = new Integer[3];
        arrayNumbers[0] = 1;
        arrayNumbers[1] = 2;
        arrayNumbers[2] = 3;

        /**
         * Arrays.asList() cria um link com o array original, as alterações refletem
         * tanto na lista quanto no array original
         * 
         * Tentar adicionar um novo elemento em uma lista que era um array
         * lança uma exceção
         */
        List<Integer> arrayToList = Arrays.asList(arrayNumbers);
        arrayToList.set(0, 12);
        // arrayToList.add(2); // java.lang.UnsupportedOperationException
        // array original
        System.out.println(Arrays.toString(arrayNumbers)); // [12, 2, 3]
        // array original convertido para list
        System.out.println(arrayToList); // [12, 2, 3]

        /**
         * Forma de criar uma lista a partir de um array que permita operação de
         * adicionar novos elementos
         */
        System.out.println("-------------------");
        List<Integer> numberList = new ArrayList<>(Arrays.asList(arrayNumbers));
        numberList.add(15);
        System.out.println(numberList); // [12, 2, 3, 15]

        /**
         * Única linha
         */
        
         // String
         List<String> string = Arrays.asList("1", "2");
         
         // Integer
         List<Integer> integer = Arrays.asList(1, 2, 3);

    }    
}
