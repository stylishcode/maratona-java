package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain.Student;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.domain.StudentData;

public class StudentTest01 {
    public static void main(String[] args) {
        Student student2 = new Student();
        Student student = new Student();
        StudentData studentData = new StudentData();

        student.name = "Midoriya";
        student.age = 15;
        student.gender = 'M';

        student2.name = "Sakura";
        student2.age = 16;
        student2.gender = 'F';

        studentData.show(student);
        studentData.show(student2);
    }
}
