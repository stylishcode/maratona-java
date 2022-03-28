package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        /*
        * Criando diretórios
        * Cria se não existir e se existir apenas cria uma referência para esse pathname
        * */
        File directory = new File("folder");
        boolean isDirectoryCreated = directory.mkdir();
        System.out.println("Directory created?: " + isDirectoryCreated);

        // Criando arquivo dentro de um diretório
//        File file = new File("folder\\file.txt");
        // Outra forma de criar arquivo dentro de um diretório
        File file = new File(directory, "file.txt");
        boolean isFileCreated = file.createNewFile();
        System.out.println("file.txt created?: " + isFileCreated);

        // Renomeando arquivos
        File renamedFile = new File(directory, "renamed_file.txt");
        boolean isRenamedFile = file.renameTo(renamedFile);
        System.out.println("file.txt renamed?: " + isRenamedFile);

        // Renomeando diretórios
        File renamedDirectory = new File("renamed_folder");
        boolean isRenamedDirectory = directory.renameTo(renamedDirectory);
        System.out.println("folder renamed?: " + isRenamedDirectory);

    }
}
