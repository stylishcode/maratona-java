package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        /*
        * BasicFileAttribuites é uma interface criada na versão 1.7 do site que visa usar polimorfismo
        * baseado no sistema operaciona. Basicamente ela é uma interface mais geral, porém tem implementações
        * mais específicas que herdam dela, a interface PosixFileAttributes (linux, unix..) e DosFileAttributes(Windows)
        *
        * São apenas métodos para leitura
        *
        * Usando File
        * */
        Instant date = LocalDateTime.now().minusDays(10).toInstant(ZoneOffset.UTC);
        File file = new File("folder2/file.txt");
        boolean isCreated = file.createNewFile();
        boolean isModified = file.setLastModified(date.toEpochMilli());

        // Usando Path
        Path path = Path.of("folder2/new_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.from(date);
        Files.setLastModifiedTime(path, fileTime);
        System.out.println("IsWritable? " + Files.isWritable(path));
        System.out.println("IsReadable? " + Files.isReadable(path));
        System.out.println("IsExecutable? " + Files.isExecutable(path));
    }
}
