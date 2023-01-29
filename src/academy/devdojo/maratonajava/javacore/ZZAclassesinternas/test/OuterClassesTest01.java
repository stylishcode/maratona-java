package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

// classe mais externa
public class OuterClassesTest01 {
    // classe interna consegue acessar sem problemas os atributos da classe mais externa
    private String name = "Monkey D. Luffy";
    // classe interna
    class Inner {
       public void printOuterClassAttribute() {
           System.out.println(name);
           // this faz referência ao contexto que ele se encontra, no caso a classe interna
           System.out.println(this);
           // esse this faz referência a classe mais externa
           System.out.println(OuterClassesTest01.this);
       }
    }

    public static void main(String[] args) {
        /*
         * Para criar um objeto da classe interna, é necessário um objeto da classe externa
         * A classe interna está fortemente acoplada com a classe externa. Isso porque existem momentos
         * em que você irá criar duas classes, por exemplo A e B e somente a classe B (mais interna), irá
         * acessar os atributos de A (mais externa), então não faz sentido B existir fora de A
         *  */
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        // possível outra forma
        // Inner inner = outerClass.new Inner();
        OuterClassesTest01.Inner inner = outerClass.new Inner();
        inner.printOuterClassAttribute();
    }
}
