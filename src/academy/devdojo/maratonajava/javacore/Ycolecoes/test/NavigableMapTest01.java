package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Consumer;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

class ConsumerByIdComparator implements Comparator<Consumer> {
    @Override
    public int compare(Consumer o1, Consumer o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}

public class NavigableMapTest01 {
    public static void main(String[] args) {
        Consumer consumer1 = new Consumer("William Suane");
        Consumer consumer2 = new Consumer("DevDojo Academy");
        Consumer consumer3 = new Consumer("Takamura Mamoru");
        Consumer consumer4 = new Consumer("Ricardo Martinez");
        Consumer consumer5 = new Consumer("Inosuke Hashibira");
        NavigableMap<Consumer, Consumer> map = new TreeMap<>(new ConsumerByIdComparator());
        map.put(consumer5, consumer1);
		map.put(consumer4, consumer2);
		map.put(consumer3, consumer3);
		map.put(consumer2, consumer4);
        map.put(consumer1, consumer5);

        for (Map.Entry<Consumer, Consumer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        NavigableMap<String, String> map2 = new TreeMap<>();
        map2.put("A", "Letra A");
        map2.put("D", "Letra D");
        map2.put("B", "Letra B");
        map2.put("C", "Letra C");
        map2.put("E", "Letra E");

        // sort é feito pela chave, valor não
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // headMap é ligado ao map. Então isso altera o map original
        System.out.println(map2.headMap("C", true).remove("B"));
        System.out.println(map2);

    }
}
