package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
        // Tratando a exceção que foi lançada/propagada
        try {
            divide(1, 0);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        // Só executa se a exceção for tratada
        System.out.println("Código finalizado");
    }

    /**
     * @param a
     * @param b cannot be zero
     * @return
     * @throws IllegalArgumentException if b equals to zero
      */

    private static int divide(int a, int b) {
        if (b == 0) {
            // Lançando/propagando a exceção para quem chamou
            throw new IllegalArgumentException("Argumento ilegal, b não deve ser zero");
        }
        return a / b;
    }
}
