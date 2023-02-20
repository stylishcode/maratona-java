package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import java.util.Scanner;

public class KeyboardInputReadTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // next() só pega a primeira string, ignora o restante após espaço
        // Ex: Olá mundo! -> Olá
        // Use o nextLine() caso deseje pegar mais de uma string
        System.out.println("Digite seu nome abaixo: ");
        String name = scanner.nextLine();
        System.out.println("Digite sua idade: ");
        int age = scanner.nextInt();
        System.out.println("Digite M ou F para seu sexo: ");
        char gender = scanner.next().charAt(0);
        System.out.println("------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}
