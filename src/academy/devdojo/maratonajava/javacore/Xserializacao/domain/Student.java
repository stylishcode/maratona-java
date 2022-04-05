package academy.devdojo.maratonajava.javacore.Xserializacao.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -7658010414567566101L;

    private final Long id;
    private final String name;
    /*
    * Como na serialização é gravados dados, não queremos que sejam guardados dados sensitivos, como a senha
    * Então utilizamos transient para dizer que não queremos guardar esse dado, ou seja, a serialização ignora-o
    *
    * O problema disso é que toda a vez que a serialização é utilizada, o Java precisa manter um "id" para saber
    * se é possível desserializar. Nesse caso, como não foi definido o id, o Java gerou baseado em algum fator x,
    * mas é como se fosse um hash e esse hash tem a garantia de que nada foi alterado. Como foi adicionado um
    * transient (não é algo que quebra o código, no máximo pode ter um password nulo), o Java entende isso
    * como uma mudança que ele pode não entender como "desserializar um objeto" e é por isso que existe o
    * serialVersionUID.
    * */
    private final transient String password;
    // Atributos estáticos pertencem a classe e não ao objeto, logo eles não são serializados
    private static final String SCHOOL_NAME = "DevDojo viradão no Jiraya";
    private transient Classroom classroom;

    public Student(Long id, String name, String password, Classroom classroom) {
        System.out.println("Dentro do construtor");
        this.id = id;
        this.name = name;
        this.password = password;
        this.classroom = classroom;
    }

    private void writeObject(ObjectOutputStream oos) {
       try {
           // Primeiramente salva da forma padrão
           oos.defaultWriteObject();
           // Depois salva tudo que não faz parte do defaultWriteObject
           oos.writeUTF(classroom.getName());
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    private void readObject(ObjectInputStream ois) {
        try {
            // Primeiramente ler da forma padrão
            ois.defaultReadObject();
            // Depois ler tudo que não faz parte do defaultWriteObject
            String classroomName = ois.readUTF();
            classroom = new Classroom(classroomName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", SCHOOL_NAME='" + Student.SCHOOL_NAME + '\'' +
                ", Classroom='" + classroom + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Classroom getClassroom() {
        return classroom;
    }
}
