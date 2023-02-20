package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.domain.Consumer;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        // Antes do Java 1.5
        List list = new ArrayList();
        list.add("Midoriya");
        list.add(123L);
        list.add(new Consumer("Goku"));

        // Problemas enfrentados
        // 1 - Qual o tipo de referência usar em um for? - Somente Object, porque não sabiamos o tipo
        for (Object o : list) {
            // 2 - Para métodos especificos de um tipo, tinha que verificar
            if (o instanceof String) {
                // algo para String
                System.out.println(o);
            }
            if (o instanceof Long) {
                // algo para Long
                System.out.println(o);
            }
            if (o instanceof Consumer) {
                // algo para consumer
                Consumer c = (Consumer) o;
                System.out.println(o);
            }
        }
        // Pensando na forma de resolver isso
        // - Como ter uma forma de type safe sem quebrar as versões anteriores
        // Solucão: Forçar um tipo em tempo de compilação
        // antes do java 7 tinha que tipar tanto a referência, quanto a implementação
        // List<String> names = new ArrayList<String>();
        // a partir do java 7, agora só precisamos tipar a referência, pois ele tipa a implementação por inferência
        List<String> names = new ArrayList<>();
        names.add("Midoriya");
        names.add("Bakugo");
        // names.add(123L); // erro

        add(list, new Consumer("All for one")); // sem erro de compilação, pois o método não é type-safety
        // Aqui da erro, pois temos um tipo não String na lista, o código não compilará
//        for(String o: list) {
//            System.out.println(o);
//        }
    }

    // comportamentos a se ter cuidado quando não se usa generics
    // note que a lista passada como argumento não está tipada, mas ela receberá uma tipada
    private static void add(List list, Consumer consumer) {
        list.add(consumer);
    }
}
