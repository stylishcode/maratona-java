package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest01 {
    public static void main(String[] args) {
        createFile();
    }

    public static void createFile() {
        File file = new File("file2\\test.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created file? " + isCreated);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
