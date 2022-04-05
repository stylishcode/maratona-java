package academy.devdojo.maratonajava.javacore.Xserializacao.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private final Long id;
    private final String name;
    private final String password;

    public Student(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
