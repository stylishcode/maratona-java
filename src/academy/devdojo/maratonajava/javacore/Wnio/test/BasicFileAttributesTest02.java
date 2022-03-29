package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("folder2/new.txt");
        /*
        * Retorna uma classe que é um BasicFileAttributes
        * Path path -> Que será lido
        * BasicFileAttributes.class -> Quando a classe Files ler e executar o método readAttributes, o objeto
        * que tem que ser retornado, quando passa no teste, é um BasicFileAttributes, não importa que tipo de
        * BasicFileAttributes vai ser retornado porque é orientado a interface
        * */
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        System.out.println("CreationTime " + creationTime);
        System.out.println("lastModifiedTime " + lastModifiedTime);
        System.out.println("lastAccessTime " + lastAccessTime);
        /*
        * BasicFileAttributes, DosFileAttributes e PosixFileAttributes são classes somente de leitura
        * Para alterar algum dado é necessário usar as classes que terminam com View, ou seja,
        * BasicFileAttributesView, DosFileAttributesView e PosixFileAttributesView
        * */
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());
        fileAttributeView.setTimes(lastModifiedTime, newCreationTime, creationTime);

        creationTime = fileAttributeView.readAttributes().creationTime();
        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();
        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();

        System.out.println("CreationTime " + creationTime);
        System.out.println("lastModifiedTime " + lastModifiedTime);
        System.out.println("lastAccessTime " + lastAccessTime);

    }
}