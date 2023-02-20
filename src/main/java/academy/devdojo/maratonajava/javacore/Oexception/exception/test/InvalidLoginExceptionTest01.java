package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.InvalidLoginException;

import java.util.Scanner;

public class InvalidLoginExceptionTest01 {
    public static void main(String[] args) {
        try {
            login();
        } catch (InvalidLoginException e) {
            e.printStackTrace();
        }
    }

    private static void login() throws InvalidLoginException {
        Scanner input = new Scanner(System.in);
        final String usernameDB = "Goku";
        final String passwordDB = "ssj";
        System.out.print("Usuário: ");
        String receivedUsername = input.nextLine();
        System.out.print("Senha: ");
        String receivedPassword = input.nextLine();
        if (!receivedUsername.equals(usernameDB)) {
            if (!receivedPassword.equals(passwordDB)) {
                throw new InvalidLoginException("Usuário ou senha inválidos");
            }
        }
        System.out.println("Usuário logado com sucesso");
    }
}
