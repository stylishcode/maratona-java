package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Computer;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.TV;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Tomato;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.service.TaxCalculator;

public class ProductTest01 {
    public static void main(String[] args) {
        Computer computer = new Computer("Acer Nitro 5", 5000);
        Tomato tomato = new Tomato("Tomate Siciliano", 10);
        TV tv = new TV("Samsung 50\"", 4000);
        TaxCalculator.calculateProductTax(computer);
        System.out.println("------------------------");
        TaxCalculator.calculateProductTax(tomato);
        System.out.println("------------------------");
        TaxCalculator.calculateProductTax(tv);
    }
}
