package academy.devdojo.maratonajava.javacore.Npolimorfismo.service;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Computer;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Tomato;

public class TaxCalculator {
    public static void calculateComputerTax(Computer computer) {
        System.out.println("Relatório de imposto do computador");
        double tax = computer.calculateTax();
        System.out.println("Computador: " + computer.getName());
        System.out.println("Valor: " + computer.getValue());
        System.out.println("Imposto a ser pago: " + tax);
    }

    public static void calculateTomatoTax(Tomato tomato) {
        System.out.println("Relatório de imposto do tomate");
        double tax = tomato.calculateTax();
        System.out.println("Tomate: " + tomato.getName());
        System.out.println("Valor: " + tomato.getValue());
        System.out.println("Imposto a ser pago: " + tax);
    }
}
