package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
    private String name = "Midoriya";
    // classe interna estática
    // não consegue acessar nada que não seja forma estática
    static class Nested {
        private String lastName = "Izuku";
        void print() {
            System.out.println(new OuterClassesTest03().name + " " + lastName);
        }
    }
    public static void main(String[] args) {
        // Não é necessário o objeto externo nesse caso, como new OuterClassesTest03.Nested()
        // Apesar de ser possível criar dessa forma
        Nested nested = new Nested();
        nested.print();
    }
}
