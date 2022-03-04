package academy.devdojo.maratonajava.javacore.Npolimorfismo.service;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Product;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Tomato;

public class TaxCalculator {
    /*
    * Teriamos que ter diferentes métodos para cada tipo de produto, se fosse 100 produtos, seria 100 métodos
    * mas usando polimorfismo e sabendo que produto é produto, independente do tipo, podemos fazer um método
    * que receba um tipo mais genérico que é Product, que vai funcionar pra qualquer classe que seja um Product
    * */
    public static void calculateProductTax(Product product) {
        System.out.println("Relatório de imposto");
        double tax = product.calculateTax();
        System.out.println("Produto: " + product.getName());
        System.out.println("Valor: " + product.getValue());
        System.out.println("Imposto a ser pago: " + tax);
        if (product instanceof Tomato) {
            Tomato tomato = (Tomato) product;
            System.out.println("Data de validade: " + tomato.getExpirationDate());
        }
    }
}
