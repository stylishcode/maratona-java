package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Scanner;

public class ScannerTest02 {
    public static void main(String[] args) {
        String text = "Levi,Eren,Mikasa,true,200";
        /*
         * E se for necessário pegar os valores "true" e 200 como booleano e inteiro, respectivamente
         * Sabemos que atualmente todos os valores são String
         * Para isso existe a classe Scanner
         * */
        Scanner scanner = new Scanner(text); // Source é a String text em vez do stdin (System.in)
        // mudando o delimitador que por padrão é o espaço em branco para virgula
        scanner.useDelimiter(",");
        /*
        * Scanner trabalha diferente da String na hora de pegar os valores. Basicamente é como se tivesse
        * dois ponteiros, o primeiro verifica se existe um próximo valor e se caso existir, um segundo ponteiro
        * pega esse valor, ou seja, um verifica, o outro pega o valor e anda para um possível próximo valor
        * */
        while(scanner.hasNext()) {
//            System.out.println(scanner.next()); // imprimindo os valores normalmente como String
            // Imprimindo os valores mas obtendo baseado nos seus tipos
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                System.out.println("Int " + value);
            } else if (scanner.hasNextBoolean()) {
                boolean value = scanner.nextBoolean();
                System.out.println("Boolean " + value);
            } else {
                System.out.println(scanner.next()); // Imprime o que não for int nem boolean
            }
        }
    }
}
