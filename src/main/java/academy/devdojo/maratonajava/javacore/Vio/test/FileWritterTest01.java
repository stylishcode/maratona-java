package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        // Não é necessário usar o método createNewFile, porque o FileWriter cria se ele não existir
        // append = true -> não sobrescreve o conteúdo e sim vai adicionando ao final da linha
        try(FileWriter fw = new FileWriter(file, true)) {
            fw.write("I'm writing inside of this file\nContinuing to write inside this file");
            /*
            * O método write escreve os dados para dentro de um buffer que depois escreve então para o disco
            * O método flush serve forçar o conteúdo do buffer a ser escrito efetivamente no disco
            * O método close() chama primeiramente o flush, porém não há garantias de que isso ocorra sempre
            * Então o ideal em cenários mais complexos é chamar explicamente o método flush antes do close
            * */
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
