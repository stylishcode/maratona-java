package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Consumer;
import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumer consumer1= new Consumer("William Suane");
        Consumer consumer2 = new Consumer("DevDojo Academy");

        Manga manga1 = new Manga(5L, "Hellsing ultimate", 19.9);
        Manga manga2 = new Manga(1L, "Berseker", 9.5);
        Manga manga3 = new Manga(4L, "Pokemon", 3.2);
        Manga manga4 = new Manga(3L, "Attack on titan", 11.20);
        Manga manga5 = new Manga(2L, "Dragon Ball Z", 2.99);

        // Associando consumidor como chave e mangá como valor
        Map<Consumer, Manga> mangaConsumers = new HashMap<>();
        mangaConsumers.put(consumer1, manga1);
        mangaConsumers.put(consumer2, manga4);

        // imprimindo chave e valor
        for (Map.Entry<Consumer, Manga> entry : mangaConsumers.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue().getName());
        }
    }
}
