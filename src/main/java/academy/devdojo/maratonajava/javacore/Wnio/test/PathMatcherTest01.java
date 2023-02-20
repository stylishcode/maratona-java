package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Path.of("folder/subpasta/file.bkp");
        Path path2 = Path.of("folder/subpasta/file.txt");
        Path path3 = Path.of("folder/subpasta/file.java");
        /*
        * Há um problema nesse caso. O * desconsidera os diretórios, ou seja, para
        * considera-los, é necessário usar ** que tudo a esquerda de .bkp será ignorado
        * e que só importa que termine com .bkp
        * */
        matches(path1, "glob:*.bkp"); // false, devido ao problema citado a cima
        matches(path1, "glob:**.bkp"); // true
        matches(path1, "glob:**/*.bkp"); // true (/* pode ser mudado por outra coisa pra dar match)
        /*
        * Match que termina com .bkp .txt ou .java
        * use {} como agrupamento (sem espaços entre os possíveis matches)
        * */
        matches(path1, "glob:**/*.{bkp,txt,java}"); // true
        matches(path2, "glob:**/*.{bkp,txt,java}"); // true
        matches(path3, "glob:**/*.{bkp,txt,java}"); // true
        /*
        * Exatamente 3 letras na extensão
        * */
        matches(path1, "glob:**/*.???"); // true
        matches(path2, "glob:**/*.???"); // true
        matches(path3, "glob:**/*.???"); // false
    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
