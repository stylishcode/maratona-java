package academy.devdojo.maratonajava.javacore.Xserializacao.test;

import academy.devdojo.maratonajava.javacore.Xserializacao.domain.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/*
* Ao serializar um objeto, é necessário dizer para o Java que ele é serializavel
* Serializable -> Serializa o Objeto em forma de bytes
* */
public class SerializationTest01 {
    public static void main(String[] args) {
        Student student = new Student(1L, "William Suane", "123412121");
//        serialize(student);
        unserialize();
    }

    /*
     * Salvando estado do objeto em um arquivo para ler posteriormente
     * */
    private static void serialize(Student student) {
        Path path = Path.of("folder/aluno.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
           oos.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * Recuperando arquivo serializado para leitura
     * Obs: Quando se lê um arquivo serializado, o Java não utiliza (executa) o construtor da classe que foi
     * desserializada. Isso significa que se estiver trabalhando com Herança, as coisas ficam um pouco mais
     * complicadas, porque em Herança, costuma-se chamar o super() dentro de um construtor e como ele não é
     * executado, o super() se torna inacessível.
     * */
    private static void unserialize() {
        Path path = Path.of("folder/aluno.ser");
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Student student = (Student) ois.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
