package academy.devdojo.maratonajava.javacore.Pwrappers.test;

public class WrapperTest01 {
    public static void main(String[] args) {
        /*
         * Tipos primitivos. Aqui estamos trabalho com bits, ou seja, o tamanho que cada tipo aloca
         * É possível alocar um int dentro de um long porque um int cabe em um long, então faz a
         * conversão implicita
         * */
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 1;
        float floatP = 1;
        double doubleP = 1;
        char charP = 1;
        boolean booleanP = false;

        /*
         * Tipos Wrappers. Agora não estamos trabalhando mais com bits e sim com objetos
         * Não é possível alocar um int dentro de um long porque é aplicado polimorfismo
         * e na linha de herança, um int não é um long
         *
         * O processo em que o java transforma um tipo primitivo para um Wrapper é chamado de autoboxing
         * É o que está sendo feito abaixo
         * */
        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1;
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 10D;
        Character charW = 'W';
        Boolean booleanW = false;
        /*
         * O processo em que o java transforma um Wrapper em um tipo primitivo é chamado de unboxing
         * */
        int i = intW; // unboxing
        Integer intW2 = Integer.parseInt("1");
        Integer intW3 = new Integer("2"); // deprecated no java 9, não faça isso
        /*
         * Todos os Wrappers aceitam parse e uma string como entrada, com exceção do Character
         * */
        Boolean isTrue = Boolean.parseBoolean("tRuE");
        System.out.println(isTrue);
        /*
        * Verificações que podem ser feitas usando Character
        * */
        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('!'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('A'));
    }
}
