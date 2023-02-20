package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.Reader01;
import academy.devdojo.maratonajava.javacore.Oexception.exception.domain.Reader02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryWithResources {
    public static void main(String[] args) {
        readFileWithTwr();
    }

    public static void readFileWithoutTwr() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFileWithTwr() {
        /*
         * O TWR se encarrega de tomar conta de fechar a conexão dessa variável de referência. Para isso,
         * é necessário seguir uma regra. Só é possível colocar objetos ou variáveis de referência dentro
         * de um TWR se as mesmas implementaram a interface Closeable ou AutoCloseable. Com isso, o java
         * se encarrega de chamar o método close para fechar os recursos usados.
         *
         * Um detalhe importante é que os recursos são fechados na ordem inversa em que foram declarados
         * Ex: Na declaração do try é reader01 e reader02, mas na hora de fechar, será fechado reader02 e reader01
         * */
        try (Reader01 reader01 = new Reader01();
             Reader02 reader02 = new Reader02()) {

        } catch (IOException e) {

        }
    }
}
