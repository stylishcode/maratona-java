package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Computer;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Product;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Tomato;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.service.TaxCalculator;

public class ProductTest03 {
    public static void main(String[] args) {
        Product product = new Computer("Acer Nitro 5", 5500);
        TaxCalculator.calculateProductTax(product);

        System.out.println("---------------------------------");

        Tomato tomato = new Tomato("Americano", 20);
        tomato.setExpirationDate("11/12/2021");
        TaxCalculator.calculateProductTax(tomato);
    }
}
