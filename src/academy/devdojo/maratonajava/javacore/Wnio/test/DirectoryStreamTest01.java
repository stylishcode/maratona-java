package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryStreamTest01 {
    public static void main(String[] args) {
        /*
        * DirectoryStream é uma das formas mais fáceis de pegar todos os arquivos de um diretório
        * O problema é que ele funciona mais ou menos como o comando "dir", ou seja, lista apenas
        * o primeiro nível de pastas e arquivos. Porém existem classes que tem um comportamento
        * diferente, ou seja, é possível ir dentro de todas as subpastas até encontrar o último nível
        * e ai voltar e continuar a busca.
        * */

        Path dir = Path.of("."); // diretório atual (maratona-java)
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }

        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
