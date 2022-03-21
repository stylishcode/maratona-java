package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringPerformanceTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        concatString(30_000);
        long end = System.currentTimeMillis();
        System.out.println("Tempo gasto para String " + (end - start) + "ms");

        start = System.currentTimeMillis();
        concatStringBuilder(1_000_000);
        end = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuilder " + (end - start) + "ms");

        start = System.currentTimeMillis();
        concatStringBuffer(1_000_000);
        end = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuffer " + (end - start) + "ms");
    }

    private static void concatString(int size) {
       String text = "";
        for (int i = 0; i < size; i++) {
            text += i; // 0, 01, 012, 0123...
        }
    }

    private static void concatStringBuilder(int size) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < size; i++) {
            text.append(i);
        }
    }

    private static void concatStringBuffer(int size) {
        // Classe que o java criou para lidar com acesso de múltiplas threads ao mesmo recurso
        // É quase a mesma coisa que StringBuilder, inclusive os métodos, só que com essa particularidade a mais
        StringBuffer text = new StringBuffer();
        for (int i = 0; i < size; i++) {
            text.append(i);
        }
    }
}
