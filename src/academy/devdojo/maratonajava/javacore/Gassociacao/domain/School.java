package academy.devdojo.maratonajava.javacore.Gassociacao.domain;

public class School {
    private String name;
    private Professor[] teachers;

    public void print() {
        System.out.println(this.name);
        if (teachers == null) return;
        for (Professor teacher : teachers) {
            System.out.println(teacher.getName());
        }
    }

    public School(String name) {
        this.name = name;
    }

    public School(String name, Professor[] teachers) {
        this.name = name;
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Professor[] teachers) {
        this.teachers = teachers;
    }
}
