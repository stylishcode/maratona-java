package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import java.util.Scanner;

public class KeyboardInputReadTest02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("O grande software de previsão do futuro");
        System.out.println("Digite sua pergunta e eu responderei sim ou não");
        String answer = input.nextLine();
        if (answer.charAt(0) == ' ') {
            System.out.println("SIM");
        } else {
            System.out.println("NÃO");
        }
    }
}
