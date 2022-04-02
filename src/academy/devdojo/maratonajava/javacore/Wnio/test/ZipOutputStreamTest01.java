package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        Path zipFile = Path.of("folder/file.zip");
        Path filesToZip = Path.of("folder/subfolder1/subsubfolder1");
        zip(zipFile, filesToZip);
    }

    private static void zip(Path zipFile, Path filesToZip) {
        try (ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(zipFile));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(filesToZip)) {
            for (Path file : directoryStream) {
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipStream.putNextEntry(zipEntry);
                Files.copy(file, zipStream);
                zipStream.closeEntry();
            }
            System.out.println("File created successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
