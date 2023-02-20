package academy.devdojo.maratonajava.javacore.Lclassesabstratas.domain;

public abstract class Person {
    /*
    * Se uma outra classe abstrata estender essa classe abstrata
    * Uma das seguintes regras deven ser seguidas:
    * A) A classe abstrata que estender essa classe não é obrigada a implementar esse método, mas
    * se implementar, só será necessário uma vez e as subclasses que herdam não precisam implementar
    *
    * B) Cada subclasse deve implementar esse método
    * */
    public abstract void print();
}
