package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest02 {
    public static void main(String[] args) {
        String name = "     Luffy     ";
        String numbers = "012345";
        // Retorna char baseado no índice
        System.out.println(name.charAt(1)); // u
        // Retorna o tamanho
        System.out.println(name.length()); // 5
        // Substitui y por x
        System.out.println(name.replace("y", "x")); // Luffx
        // Transforma a String inteira em minúscula
        System.out.println(name.toLowerCase());
        // Transforma a String inteira em minúscula
        System.out.println(name.toUpperCase());
        // Retorna a substring (indice inicial, indice final - 1)
        System.out.println(numbers.substring(0, 2)); // 01
        // Retorna a substring (indice inicial até o final)
        System.out.println(numbers.substring(3)); // 345
        // Remove os espaços em branco no início e no fim da String
        System.out.println(name.trim());
    }
}
