package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {
    public static void main(String[] args) {
        try {
//            throw new ArrayIndexOutOfBoundsException();
//            throw new IndexOutOfBoundsException();
//            throw new IllegalArgumentException();
//            throw new ArithmeticException();
            throw new RuntimeException();
        } /*catch (RuntimeException e) {
             * Exceções mais genéricas sempre devem vir por último, pois
             * como as outras herdam da genérica, ela acaba inutilizando
             * as outras (unreachable code)
             *//*
            System.out.println("Dentro do RuntimeException");
        }*/ catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Dentro do IndexOutOfBoundsException");
        } catch (IllegalArgumentException e) {
            System.out.println("Dentro do IllegalArgumentException");
        } catch (ArithmeticException e) {
            System.out.println("Dentro do ArithmeticException");
        } catch (RuntimeException e) {
            System.out.println("Dentro do RuntimeException");
        }

        try {
            maybeThrowException();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void maybeThrowException() throws SQLException, FileNotFoundException {

    }
}