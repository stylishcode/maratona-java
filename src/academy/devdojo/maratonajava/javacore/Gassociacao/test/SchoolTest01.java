package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.domain.School;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Teacher;

public class SchoolTest01 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Jiraya Sensei");
        Teacher teacher2 = new Teacher("Kakashi Sensei");
        Teacher[] teachers = new Teacher[] {teacher, teacher2};
        School school = new School("Konoha", teachers);

        school.print();
    }
}
