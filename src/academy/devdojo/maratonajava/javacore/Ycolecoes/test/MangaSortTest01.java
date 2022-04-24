package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Comparator serve para definir uma ordenação específica e passar como argumento
// para o método sort. É diferente de Comparable, onde é necessário que a classe
// implemente Comparable e só ter uma implementação de sort definida. Com Comparable
// podemos ter diversas classes de sort e apenas passar como argumento para o sort
class MangaByIdComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }

}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L, "Hellsing ultimate", 19.9));
        mangas.add(new Manga(1L, "Berseker", 9.5));
        mangas.add(new Manga(4L, "Pokemon", 3.2));
        mangas.add(new Manga(3L, "Attack on titan", 11.20));
        mangas.add(new Manga(2L, "Dragon Ball Z", 2.99));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("--------------------------------");
        /*
         * Sorted mangas (Quem chama o método compareTo é o Java e ele lança exceção se a classe a ser
         * organizada não implementar o Comparable, que a forma que o Java conhece de ordenar as coisas)
         */
        // Collections.sort(mangas, new MangaByIdComparator()); // Usando comparator
        mangas.sort(new MangaByIdComparator()); // Forma que obrigatoriamente recebe um Comparator
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
