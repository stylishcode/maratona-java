package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        List<Dog> dogs = List.of(new Dog(), new Dog());
        List<Cat> cats = List.of(new Cat(), new Cat());
        printConsult(dogs);
        printConsult(cats);
        // Para List<? super Dog>
        // Dog < Animal < Object
        List<Animal> animals = new ArrayList<>();
        printAnimalConsult(animals);
//        printAnimalConsult(dogs);
        // também poderia List<Object>

        // Para List<? super Animal>
        // Animal < Object
        List<Animal> animals1 = new ArrayList<>();
        printAnimalConsult(animals1);
//        printAnimalConsult(dogs); // Não pode, é subclasse de Animal e não super
    }
    
    private static void printConsult(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.consult();
//            animals.add(new Cat()); // não pode
        }
    }

    // Dog < Animal < Object
//    private static void printAnimalConsult(List<? super Dog> animals) {
//
//    }

    // Animal < Object
    private static void printAnimalConsult(List<? super Animal> animals) {

    }
}
