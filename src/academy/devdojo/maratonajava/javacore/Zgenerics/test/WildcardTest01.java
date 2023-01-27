package academy.devdojo.maratonajava.javacore.Zgenerics.test;

abstract class Animal {
    public abstract void consult();
}

class Dog extends Animal {
    @Override
    public void consult() {
        System.out.println("Consultando doguinho");
    }
}

class Cat extends Animal {
    @Override
    public void consult() {
        System.out.println("Consultando gato");
    }
}
public class WildcardTest01 {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog(), new Dog()};
        Cat[] cats = {new Cat(), new Cat()};
        printConsult(dogs);
        printConsult(cats);
        // tudo abaixo funciona devido ao polimorfismo
        Animal[] animals = {new Cat(), new Dog()};
        Animal animal = new Cat();
        printConsult(animals);
    }
    
    private static void printConsult(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consult();
        }
//        animals[1] = new Cat(); // ClassCastException
    }
}
