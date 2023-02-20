package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        /*
         * Várias classes foram introduzidas nesse novo pacote (NIO).
         * Sabemos que a classe File existe desde os primordios do Java
         * Porém esse novo pacote trouxe performance e métodos mais intuitivos e
         * outros benefícios.
         *
         * Foi criada uma interface para trabalhar no lugar da classe File, Path.
         * Para criar um Path, é necessária o uso de uma classe, a Paths
         *
         * Todas as funcionalidades de File foram movidas para uma outra classe chamada
         * Files.
         * */
        Path path = Paths.get("C:\\Users\\stylish\\Projects\\maratona-java\\file.txt");
        System.out.println(path.getFileName()); // file.txt
        // É possível transformar Path em File e File em Path
//        File pathToFile = path.toFile();
//        Path fileToPath = pathToFile.toPath();
        /*
        * É possível passar um varargs para Paths.get() passando o caminho, diretório por diretorio
        * E ele se encarrega de montar o path corretamente
        * */
        Path path2 = Paths.get("C:\\Users\\stylish\\Projects\\maratona-java", "file.txt");
        Path path3 = Paths.get("C:", "Users\\stylish\\Projects\\maratona-java", "file.txt");
        Path path4 = Paths.get("C:", "Users", "stylish", "Projects", "maratona-java", "file.txt");
        System.out.println(path2.getFileName());
        System.out.println(path3.getFileName());
        System.out.println(path4.getFileName());
        /*
        * Recomenda-se utilizar Path.of (a partir do java 11), pois Paths.get está depreciando
        * */
    }
}
