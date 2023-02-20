package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        String name = "Willian Suane";
        // Como visto anteriormente, Strings são imutaveis
        name.concat(" DevDojo");
        System.out.println(name); // "Willian Suane
        // Porém, com StringBuilder, esse conceito não se aplica mais
        // Por padrão o StringBuilder aloca espaço para 16 caracteres, e vai se expandindo conforme a necessidade
        // Você pode chamar o construtor vazio, construtor passando uma String inicial e um passando o tamanho
        StringBuilder sb = new StringBuilder("Willian Suane");
        sb.append(" DevDojo").append(" Academy"); // vários appends afetam a legibilidade do código
        /* não altera a String porque o String builder não está manipulando-a e o substring retorna uma String,
        então seria necessário armazenar em uma variável */
        sb.substring(0, 3); // ignorado
//        String substring = sb.substring(0, 3); // valido
        System.out.println(sb);
        sb.reverse(); // inverte a String
        sb.reverse(); // inverte novamente, voltando ao normal
        System.out.println(sb);
        // Deleta da posição 0 até a posição 3 - 1 (2)
        sb.delete(0, 3); // Wil
        System.out.println(sb);
    }
}
