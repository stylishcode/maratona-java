package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.domain.School;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Professor;

public class SchoolTest01 {
    public static void main(String[] args) {
        Professor teacher = new Professor("Jiraya Sensei");
        Professor teacher2 = new Professor("Kakashi Sensei");
        Professor[] teachers = new Professor[] {teacher, teacher2};
        School school = new School("Konoha", teachers);

        school.print();
    }
}
