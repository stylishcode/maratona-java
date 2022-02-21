package academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain;

public class StudentData {
    public void show(Student student) {
        System.out.println("-----------------------------");
        System.out.println("Name: " + student.name);
        System.out.println("Age: " + student.age);
        System.out.println("Gender: " + student.gender);
    }
}
