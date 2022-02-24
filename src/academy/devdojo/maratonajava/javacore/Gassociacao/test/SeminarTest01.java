package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Place;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Seminar;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Student;
import academy.devdojo.maratonajava.javacore.Gassociacao.domain.Professor;

public class SeminarTest01 {
    public static void main(String[] args) {
        /*
         * Definir onde será o local
         * Criar seminário
         * Definir os alunos que irão participar
         * Definir os professores que serão responsáveis pelo seminários
         * */
        Place place1 = new Place("Korakuen Hall");
        Seminar seminar1 = new Seminar("Inteligência Artificial", place1);

        Place place2 = new Place("Ryogoku Kokugikan");
        Seminar seminar2 = new Seminar("Programação Orientada a Objeto", place2);

        Place place3 = new Place("Yokohama Arena");
        Seminar seminar3 = new Seminar("Entendendo back-end", place3);

        Professor professor1 = new Professor("Kamogawa", "Software Engineer");
        Professor professor2 = new Professor("Fabio Akita", "CEO CodeMiner 42");

        professor1.setSeminaries(seminar1, seminar2);
        professor2.setSeminaries(seminar3);

        Student student1 = new Student("Jailson", 22, seminar1);
        Student student2 = new Student("Matheus", 24, seminar1);
        Student student3 = new Student("Marcelo", 24, seminar2);
        Student student4 = new Student("Yasmim", 23, seminar2);
        Student student5 = new Student("Nayara", 21, seminar3);
        Student student6 = new Student("Jhimmy", 20, seminar3);

        seminar1.setStudents(student1, student2);
        seminar2.setStudents(student3, student4);
        seminar3.setStudents(student5, student6);

        System.out.println("---------- INFO SEMINÁRIOS ----------");
        Seminar[] seminaries = new Seminar[]{seminar1, seminar2, seminar3};
        Professor[] professors = new Professor[]{professor1, professor2};

        for (Seminar seminary : seminaries) {
            System.out.println("Título: " + seminary.getTitle());
            System.out.println("Local: " + seminary.getPlace().getAddress());
            System.out.println();
        }

        System.out.println("---------------- INFO ALUNOS ----------------");
        for (Seminar seminary : seminaries) {
            for (Student student : seminary.getStudents()) {
                System.out.println("Nome: " + student.getName());
                System.out.println("Idade: " + student.getAge());
                System.out.println("Participando do seminário de: " + student.getSeminar().getTitle());
                System.out.println();
            }
        }

        System.out.println("----------------- INFO PROFESSORES -----------------");
        for (Professor professor : professors) {
            // Ignora professores que não estão responsáveis por seminários, mesmo estando na lista de professores
            if (professor.getSeminaries() == null) continue;
            System.out.println("Nome: " + professor.getName());
            System.out.println("Especialidade: " + professor.getResearchField());
            System.out.print("Responsável pelo(s) seminário(s) de: ");
            for (Seminar seminary : professor.getSeminaries()) {
                System.out.print(seminary.getTitle() + " ");
            }
            System.out.println("\n");
        }

    }
}
