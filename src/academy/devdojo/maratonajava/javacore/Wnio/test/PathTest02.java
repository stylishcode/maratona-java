package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        /*
         * Recomenda-se utilizar Path.of (a partir do java 11), pois Paths.get está depreciando
         *
         * Criando único diretório (lança FileAlreadyExistsException se o diretório existir)
         * Como cria um único diretório, Files.createDirectory lança exceção se a pasta pai não existir
         * */
        Path folderPath = Path.of("folder");
        if (Files.notExists(folderPath)) {
            Path folderDir = Files.createDirectory(folderPath);
        }
        /*
        * Criando múltiplos diretórios (não lança exceção caso o diretório já exista
        * Files.createDirectories serve para criar um único diretório também
        * */
        Path subfoldersPath =  Path.of("folder/subfolder/subsubfolder");
        Path subFoldersDir = Files.createDirectories(subfoldersPath);
        /*
        * Criando arquivos
        * */
        Path filepath = Path.of(subfoldersPath.toString(), "file.txt");
        if (Files.notExists(filepath)) {
            Path filePathCreated = Files.createFile(filepath);
        }
        /*
        * Copiando arquivos
        * */
        Path source = filepath;
        // getParent() retorna o pai de file.txt que é "folder/subfolder/subsubfolder"
        Path target = Path.of(filepath.getParent().toString(), "file_renamed.txt");
        /*
        * Lança FileAlreadyExistsException se o arquivo existir, mesmo que haja alterações nele
        * StandardCopyOption.REPLACE_EXISTING -> substitui existente, se existir, resolvendo o erro acima
        * */
        Path renamedFile = Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
