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
        }
        names.add("Suane");
        System.out.println("-----------------");
        // Percorrendo lista com for indexado
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

    }
}
