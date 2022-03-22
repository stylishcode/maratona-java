package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        // Date não é mais tão utilizada, obsoleta devido a má capacidade de lidar com internacionalização
        // Date trabalha em milissegundos, o valor que ele tem dentro é um long os milissegundos desde abril de 1970
        Date date = new Date(1_000_000_000);
        System.out.println(date); // 12 jan 1970, 10:46:40
        System.out.println(date.getTime()); //1000000000
        System.out.println("Hoje");
        Date today = new Date();
        System.out.println(today); // 22/3/2022 03:05:21
        System.out.println(today.getTime()); // 1647929121926
        // Adicionando uma hora
        today.setTime(today.getTime() + 3_600_000);
        System.out.println(today); // 22/3/2022 04:05:21
    }
}
