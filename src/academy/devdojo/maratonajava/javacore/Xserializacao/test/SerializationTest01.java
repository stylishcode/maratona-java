package academy.devdojo.maratonajava.javacore.Xserializacao.test;

import academy.devdojo.maratonajava.javacore.Xserializacao.domain.Classroom;
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
        /*
        * Student é serializável mas Classroom não, porém Student tem uma Classroom e a execução do código
        * lançará NotSerializableException. Para resolver, é necessário passar a instrução para o Java de como
        * serializar/desserializar Classroom (claro que seria possível fazer Classroom implementar Serializable,
        * mas imagine o caso onde você use API's e não tem como acessar o código fonte para fazer a mudança).
        *
        * Primeiro, adicionar transient no atributo Classroom em Student ignorar Classroom na serialização
        *
        * Segundo, adicionar os métodos writeObject e readObject em Student (deve seguir essa nomenclatura
        * e não confundir com a possível sobrescrita writeObject e readObject das Streams. Anote os métodos
        * com @Serial do java.io se sua versão da JDK for 14
        *
        * Terceiro, dentro de writeObject, salvar o padrão com oos.defaultWriteObject(), depois salva tudo
        * o que não faz parte do defaultWriteObject(), no caso a Classroom com o writeUTF(classroom.getName())
        * writeUTF porque vai salvar uma String que pode ser unicode, mas tem para outros tipos também e se
        * tivesse mais tipos a salvar, salvaria de um por um com o write correspondente
        *
        * Quarto, fazer o mesmo para leitura, mudando a lógica para leitura
        * */
        Classroom classroom = new Classroom("Maratona Java");
        Student student = new Student(1L, "William Suane", "123412121", classroom);
        serialize(student);
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
