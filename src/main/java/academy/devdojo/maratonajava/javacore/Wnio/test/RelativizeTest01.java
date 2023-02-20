package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;

public class RelativizeTest01 {
    public static void main(String[] args) {
        Path dir = Path.of("/home/stylish");
        Path classFile = Path.of("/home/stylish/projects/HelloWorld.java");
        Path pathToClassFile = dir.relativize(classFile);
        /*
        * Basicamente só é necessário, segundo o relativize, ir para projects/HelloWorld.java, pois
        * já nos encontramos na raiz /home/stylish
        * */
        System.out.println(pathToClassFile);
        /*
        * Outros exemplos
        * */
        Path absolute1 = Path.of("/home/stylish");
        Path absolute2 = Path.of("/usr/local");
        Path absolute3 = Path.of("/home/stylish/projects/HelloWorld.java");
        Path relative1 = Path.of("temp");
        Path relative2 = Path.of("temp/temp.20222903");

        System.out.println("1 " + absolute1.relativize(absolute3)); // 1 projects\HelloWorld.java
        System.out.println("2 " + absolute3.relativize(absolute1)); // 2 ..\..
        System.out.println("3 " + absolute1.relativize(absolute2)); // 3 ..\..\ usr\local
        System.out.println("4 " + relative1.relativize(relative2)); // 4 temp.20222903
        System.out.println("5 " + absolute1.relativize(relative1)); // 5 Erro, Java não sabe como chegar em temp
    }
}
