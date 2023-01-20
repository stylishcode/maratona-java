package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneBrandComparator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}

class MangaPriceComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneBrandComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");
        set.add(smartphone);

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPriceComparator());
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berserk", 9.5, 5));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99, 0));
        mangas.add(new Manga(10L, "Aaragon", 2.99, 0));
//        for (Manga manga : mangas) {
//            System.out.println(manga);
//        }
        // inverte a ordem de exibição do TreeSet
        for (Manga manga : mangas.descendingSet()) {
            System.out.println(manga);
        }

        System.out.println("----------------");

        Manga yuyu = new Manga(19L, "Tokyo Revengers", 19.9, 5);

        // mangas.lower(yuyu) -> retorna o < preço depois de yuyu
        // mangas.floor(yuyu) -> retorna o <= preço depois de yuyu
        // mangas.higher(yuyu) -> retorna o > preço depois de yuyu
        // mangas.ceiling(yuyu) -> retorna o >= preço depois de yuyu

        System.out.println(mangas.ceiling(yuyu));

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst()); // retorna e remove o primeiro elemento do TreeSet
        System.out.println(mangas.pollLast()); // retorna e remove o ultimo elemento do TreeSet
        System.out.println(mangas.size());
    }
}
