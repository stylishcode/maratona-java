package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileReader fr = new FileReader(file)) {
            /*
            * O método fr.read() retorna um int que é o ascii do primeiro caractere lido
            * ou -1 se tiver chegado ao fim da stream
            * */
//            Lendo 30 caracteres, armazenando no array de char e exibindo
//            char[] in = new char[30];
//            int size = fr.read(in); // retorna a quantidade de caracteres lidos exceto fim da linha (int)
//            System.out.print(size);
//            for (char c : in) {
//                System.out.print(c);
//            }
//            Lendo o arquivo até o fim da linha
            int i;
            while((i = fr.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
