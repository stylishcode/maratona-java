package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
    public static void main(String[] args) {
        /*
         * FileWriter e FileReader são classes bem low level, não foram criadas com os pensamentos de
         * performance em mente. Então se estiver trabalhando com arquivos muito grandes é melhor utilizar
         * as classes BufferedWriter (escrita) e BufferedReader (leitura)
         * */
        File file = new File("file.txt");
        /*
         * Sobre os encadeamentos das classes de IO: Temos a classe File, FileWritter recebe um File, BufferedWritter
         * recebe um FileWritter
         *
         * File file faz a referência para um arquivo
         * FileWritter fw é responsável pela escrita no arquivo mas não é otimizado
         * BufferedWritter bw que é otimizada, encapsula FileWritter fw que agora passa a utilizar um buffer e ao
         * invés de imprimir os dados diretamente no console, irá guardar os dados nesse buffer, porque é mais
         * rápido escrever na memória, para ai sim depois escrever no disco
         * */
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("I'm writing inside this file");
            // \n pode não funcionar em todos os sistemas operacionais, então BufferedWritter provê esse método
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
