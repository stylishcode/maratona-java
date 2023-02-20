package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest02 {
    private String name = "Bakugo";

    /*
     * Local classes é quando você tem uma classe dentro de um método ou bloco de inicialização.
     * O uso não é comum, mas vale a pena saber que existe.
     *  */
    // parametros precisam ser finais ou efetivamente finais (não alterados)
    void print(String param) {
        // precisa ser final ou efetivamente final (não alterado)
        String lastName = "Izuku";
        // altera sem problemas o atributo da classe mais externa
        name = "Midoriya";
        /*
         * Classe Local
         * Ainda tem acesso aos atributos da classe mais externa
         * Também permite atributos, métodos e construtores
         *
         * são permitidos modificadores abstract e final somente, assim como nos métodos
         * */
        class LocalClass {
            public void printLocal() {
                System.out.println(param);
                System.out.println(name + " " + lastName);
            }
        }
        /*
         * Você não acesso essa classe local, uma vez que a execução desse método termina.
         * Então essa classe precisa ser inicializada onde ela se encontra. Essa é a única
         * forma de se usar as classes locais
         *  */
//        LocalClass localClass = new LocalClass();
//        localClass.printLocal();
        // outra forma
        new LocalClass().printLocal();
    }
    public static void main(String[] args) {
        /*
         * O método print se encarrega de executar o que está dentro dele
         *  */
        OuterClassesTest02 outer = new OuterClassesTest02();
        outer.print("Ola");
    }
}
