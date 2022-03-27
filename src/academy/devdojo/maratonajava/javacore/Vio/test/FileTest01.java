package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FileTest01 {
    public static void main(String[] args) {
        /*
         * Criando uma variável de referência File com um Objeto File recebendo o caminho do arquivo
         * Pode ser criado:
         * - Na raiz (new File("file.txt")) criara na pasta maratona-java
         * - Local dentro da raiz (new File("file\\file.txt")) criara na pasta file dentro de maratona-java
         * - Qualquer outro local passando um caminho absoluto (new File("C:\\Users\\stylish\\Documents\\file.txt"))
         *
         * Não pode ser criado:
         * - Em locais onde o usuário não tem permissão, ex.: C:\\ProgramFiles (IOException - Access is Denied)
         *
         * Obs: A linha 2 não criará o arquivo
         */
        File file = new File("file.txt");
        // Criando o arquivo, efetivamente
        try {
            // Cria o arquivo e retorna true se criado (caso o arquivo já exista, não será recriado e retorna false)
            boolean isCreated = file.createNewFile();
            System.out.println("Created: " + isCreated);
            // Paths
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            // É um diretório?
            System.out.println("Directory?: " + file.isDirectory());
            // É um arquivo?
            System.out.println("File?: " + file.isFile());
            // É oculto?
            System.out.println("Oculto?: " + file.isHidden());
            // Última modificação (retorna um long)
            Instant instant = Instant.ofEpochMilli(file.lastModified());
            LocalDateTime lastModified = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            System.out.println("Last modified: " + lastModified.format(DateTimeFormatter
                    .ofPattern("dd/MM/yyyy HH:mm:ss.SSS", new Locale("pt", "BR"))));
            // Excluindo o arquivo
            if (file.exists()) {
                System.out.println("Deleted: " + file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
