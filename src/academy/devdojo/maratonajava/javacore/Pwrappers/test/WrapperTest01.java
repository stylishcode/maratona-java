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
        * */
        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1;
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 10D;
        Character charW = 'W';
        Boolean booleanW = false;
    }
}
