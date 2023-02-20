package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        // até a versão 1.4 não era especificado o tipo e a lista poderia ter vários tipos
//        List names = new ArrayList();
//        names.add("William");
//        names.add("DevDojo Academy");
//        names.add(121); // funciona
//
//        for (Object name : names) {
//            System.out.println(name); // "William", "DevDojo Academy", 121
//        }

        // Porém depois, com a introdução de generics, o Java força em tempo de compilação, a definição do tipo

        List<String> names = new ArrayList<>();
        names.add("William");
        names.add("DevDojo Academy");
//        names.add(121); // Agora não funciona, pois o tipo é int
        for (String name : names) {
            System.out.println(name);
//            names.add("Matheus"); // não pode, lança ConcurrentModificationException
        }
        names.add("Suane");
        System.out.println("-----------------");
        // Percorrendo lista com for indexado
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
//            names.add("Matheus"); // pode, porém entra em loop infinito porque o size da lista sempre vai aumentar em +1
        }

        // Removendo por indice
        System.out.println(names.remove(0)); // William

        // Removendo por Objeto
        names.remove("Suane"); // true se a lista conter o elemento especificado
        System.out.println("------ após remoção ------");
        for (String name : names) {
            System.out.println(name);
        }

        // Criando uma nova lista e adicionando ela a lista name
        List<String> names2 = new ArrayList<>();
        names2.add("Matheus");
        names2.add("Henrique");
        names.addAll(names2);

        System.out.println("------Após adicionar names2 a names------");
        for (String name : names) {
            System.out.println(name);
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
    }
}
