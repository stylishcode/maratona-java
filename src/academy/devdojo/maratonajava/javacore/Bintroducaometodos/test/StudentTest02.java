package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain.Student;

public class StudentTest02 {
    public static void main(String[] args) {
        Student student = new Student();
        Student student2 = new Student();

        student.name = "Midoriya";
        student.age = 15;
        student.gender = 'M';

        student2.name = "Sakura";
        student2.age = 16;
        student2.gender = 'F';

        student.showData();
        student2.showData();
    }
}
