package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.domain.Boat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Animal {
    public void walk() {
        System.out.println("Animal Walking");
    }
}

// Essa implementação pode ir para dentro da uma classe anônima caso o uso seja de uma única vez
class BoatNameComparator implements Comparator<Boat> {
    @Override
    public int compare(Boat o1, Boat o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        /*
        * Classe anônima (classe sem nome). Parece que estamos criando um objeto do tipo Animal, mas
        * na verdade estamos criando uma subclasse dele
        *
        * Não há como criar outros métodos nessa subclasse, porque a variável de referência Animal
        * não tem acesso a esse método, pois ele não existe lá
        * */
        // primeiro exemplo
       Animal dog = new Animal(){
           @Override
           public void walk() {
               System.out.println("Dog walking in the shadows");
           }
       };
       dog.walk();
       // segundo exemplo
        List<Boat> boatList = new ArrayList<>(List.of(new Boat("Lancha"), new Boat("Canoa")));
        // Classe anônima dentro do método sort
        boatList.sort(new Comparator<Boat>() {
            @Override
            public int compare(Boat o1, Boat o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(boatList);
    }
}
