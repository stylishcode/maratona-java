package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Computer;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Tomato;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.service.TaxCalculator;

public class ProductTest01 {
    public static void main(String[] args) {
        Computer computer = new Computer("Acer Nitro 5", 5000);
        Tomato tomato = new Tomato("Tomate Siciliano", 10);
        TaxCalculator.calculateComputerTax(computer);
        System.out.println("------------------");
        TaxCalculator.calculateTomatoTax(tomato);
    }
}
