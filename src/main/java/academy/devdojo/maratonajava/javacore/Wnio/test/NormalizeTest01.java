package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String projectDir = "home/stylish/dev";
        String fileTxt = "../../file.txt";
        Path path1 = Path.of(projectDir, fileTxt);
        /*
         * home\stylish\dev\..\..\file.txt (path não normalizado)
         * home\stylish\dev\file.txt (path normalizado)
         * */
        System.out.println("Não normalizado: " + path1);
        System.out.println("Normalizado: " +path1.normalize());

        Path path2 = Path.of("/home/./stylish/./dev/");
        System.out.println("Não normalizado: " + path2);
        System.out.println("Normalizado: " +path2.normalize());
    }
}
