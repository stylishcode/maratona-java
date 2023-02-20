package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.LinkedHashSet;
import java.util.Set;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

public class SetTest01 {
    public static void main(String[] args) {
        /**
         * Set é uma interface que é uma Collection, assim como List
         * Set não permite elementos duplicados dentro da coleção
         * HashSet é uma coleção onde é permitido apenas elementos únicos organi-
         * zados por Hash, ou seja, não tem como garantir como os elementos estarão
         * dentro da lista porque eles podem se reajustar baseado no que é inserido
         * 
         * Caso você deseje manter a ordem de inserção, utilize a classe LinkedHashSet
         */
        // Set<Manga> mangas = new HashSet<>(); // Não mantém a ordem de inserção
        Set<Manga> mangas = new LinkedHashSet<>(); // Não mantém a ordem de inserção
        mangas.add(new Manga(5L, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berserk", 9.5, 5));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99, 0));
        /**
         * Esta inserção será ignorada, pois Set não aceita elementos duplicados
         * Ele usa o método equals para verificar a existência de um elemento exatamente igual
         * e se existir, ele não adiciona
         */
        mangas.add(new Manga(2L, "Dragon ball Z", 2.99, 0)); // Ignora a adição (Não dá erro, somente ignora)

        /**
         * Set não é indexado, então não tem métodos para pegar o índice de algum
         * elemento, então você precisa navegar pela coleção (usando foreach por ex)
         */

        for (Manga manga : mangas) {
            System.out.println(manga);   
        }
    }    
}
