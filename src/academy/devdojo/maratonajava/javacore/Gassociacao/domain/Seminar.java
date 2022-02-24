package academy.devdojo.maratonajava.javacore.Gassociacao.domain;

public class Seminar {
    private final String title;
    private final Place place;
    private Student[] students;

    public Seminar(String title, Place place) {
        this.title = title;
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public Place getPlace() {
        return place;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student... students) {
        this.students = students;
    }
}
