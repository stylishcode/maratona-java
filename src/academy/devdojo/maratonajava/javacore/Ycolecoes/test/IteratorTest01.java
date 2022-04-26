package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Hellsing ultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berseker", 9.5, 5));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Attack on titan", 11.20, 2));
        mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 0));

        /**
         * Removendo dados de uma lista usando Iterator
         * 
         * Iterator é uma classe que checa antes de fazer alguma ação
         * Imagine que você está em um banco, olhando a fila do banco e que
         * você é o Iterator é a fila é os mangas, você antes de chamar alguém
         * da fila vai verificar: "Tem alguém na fila?", se sim, você chama.
         */
        Iterator<Manga> mangaIterator = mangas.iterator();
        while (mangaIterator.hasNext()) {
            if (mangaIterator.next().getAmount() == 0) {
                mangaIterator.remove();
            }
        }
        // System.out.println(mangas);
        
        /** Usando o removeIf() do java 8 */
        mangas.removeIf(manga -> manga.getAmount() == 0);
        System.out.println(mangas);

    }
}
