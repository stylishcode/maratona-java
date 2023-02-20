package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;

public class ResolveTest01 {
    public static void main(String[] args) {
        // Mesmo sendo relativo, o Java encontra porque está na raiz (maratona-java)
        Path dir = Path.of("home/stylish");
        // Por ser relativo, o Java não encontra porque não está na raiz
        Path file = Path.of("dev/file.txt");
        // Resolvendo path
        Path resolve = dir.resolve(file);
        System.out.println(resolve);
        /*
        * O resolve une os paths, porém ele não é tão inteligente assim
        * O que acontece se misturar caminho absoluto com relativo?
        * */
        Path absolute = Path.of("/home/stylish");
        Path relative = Path.of("dev");
        Path file2 = Path.of("file.txt");
        /*
        * Absoluto resolve relativo funciona
        * Relativo resolve absoluto não funciona porque não tem como resolver o que já é absoluto
        * Se você tentar resolver relativo com absoluto, ele simplesmente retorna o absoluto
        * */
        System.out.println("1 " + absolute.resolve(relative)); // resolveu
        System.out.println("2 " + absolute.resolve(file2));  // resolveu
        System.out.println("3 " + relative.resolve(absolute)); // não resolveu, apenas retornou o absoluto
        System.out.println("4 " + relative.resolve(file2)); // resolveu
        System.out.println("5 " + file.resolve(absolute)); // não resolveu, apenas retornou o absoluto
        System.out.println("6 " + file.resolve(relative)); // resolveu
    }
}
