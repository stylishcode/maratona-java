package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    /*
     * Chamado para um diretório antes que as entradas no diretório sejam visitadas,
     * ou seja, antes de entrar no diretório e listar o conteúdo, preVisitDirectory é executado
     * Se este método retornar CONTINUE, as entradas do diretório serão visitadas.
     * Se este método retornar SKIP_SUBTREE ou SKIP_SIBLINGS, as entradas no diretório (e quaisquer
     * descendentes) não serão visitadas.
     *
     * Obs: altere para CONTINUE, SKIP_SUBTREE ou SKIP_SIBLINGS no método visitFile e não neste método
     *
     * Não é garantido que esse método tenha o mesmo comportamento sempre
     * ex FileVisitResult.CONTINUE.:
     *  pre visit folder
     *  pre visit subfolder1
     *  pre visit subsubfolder1
     *  subsubfile1.txt
     *  pre visit subfolder2
     *  subfile2.txt
     *  test.txt
     *
     * ex FileVisitResult.SKIP_SUBTREE.:
     *  pre visit folder
     *
     * ex FileVisitResult.SKIP_SIBLINGS.:
     *  pre visit folder
     *  pre visit subfolder1
     *  pre visit subsubfolder1
     *  subsubfile1.txt (ignorou o irmão subsubfile2.txt)
     *  pre visit subfolder2
     *  subfile2.txt
     *  test.txt
     *
     * */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("pre visit " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    /*
     * Invocado para um arquivo que não pôde ser visitado.
     * Este método é invocado se os atributos do arquivo não puderem ser lidos,
     * o arquivo for um diretório que não pôde ser aberto e outros motivos.
     * */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    /*
    * Chamado para um diretório após as entradas no diretório e todos os seus descendentes terem sido visitados.
    * Esse método também é invocado quando a iteração do diretório é concluída prematuramente (por um método
    * visitFile retornando SKIP_SIBLINGS ou um erro de E/S ao iterar no diretório).
    * */
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("post visit " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }
}

public class SimpleFileVisitorTest02 {
    public static void main(String[] args) throws IOException {
        Path root = Path.of("folder"); // diretorio atual (maratona-java)
        Files.walkFileTree(root, new ListAllFiles());
    }
}
