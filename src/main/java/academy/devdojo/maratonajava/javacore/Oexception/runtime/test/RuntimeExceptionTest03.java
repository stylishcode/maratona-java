package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
        openConnection2();
    }

    private static String openConnection() {
        try {
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo dados no arquivo");
            return "Connection open successfull";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // sempre será executado, independente de ter exceção ou não
            System.out.println("Fechando recurso liberado pelo SO");
        }
        return null;
    }

    /*
     * É possível usar o try sem o catch, apesar de não ser tão utilizado.
     * O código funciona porém fica sem tratamento
     */
    private static void openConnection2() {
        try {
            System.out.println("Abrindo arquivo");
            System.out.println("Escrevendo dados no arquivo");
            throw new RuntimeException();
        } finally {
            System.out.println("Fechando recurso liberado pelo SO");
        }
    }
}
