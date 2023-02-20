package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Computer;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Product;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.domain.Tomato;

public class ProductTest02 {
    public static void main(String[] args) {
        /*
        * A conversão de tipo em Java é usada para converter objetos ou variáveis de um tipo em outro.
        * Quando estamos convertendo ou atribuindo um tipo de dados a outro, eles podem não ser compatíveis.
        * Se for adequado, funcionará sem problemas, caso contrário, haverá chances de perda de dados.
        *
        * Tipos de conversão de tipos em Java
        *   O Java Type Casting é classificado em dois tipos.
        *       - Widening cast (Ímplicito) - conversão automática de tipo
        *       - Narrowing cast (explicito) - precisa de conversão explicita
        *
        * Widening Cast (menor para o maior tipo): Pode ocorrer se os dois tipos forem compatíveis e o tipo
        * destino for maior que o tipo origem
        * ex.:
        * byte source = 40;
        * short target = source; (não precisa de casting pra short)
        *
        * Widening Cast (Tipo de classe): No exemplo abaixo, a classe Computer e Tomato são os tipos menores
        * que estamos atribuindo ao tipo de classe Product, que é um tipo maior, portanto,
        * nenhuma conversão é necessária.
        *
        * Narrowing Cast (maior para o menor tipo): Quando estamos atribuindo um tipo maior a um tipo menor,
        * a conversão explicita é necessária.
        * ex.:
        * double source = 30.0;
        * float target = (float) source; (precisa do casting explícito pra float)
        *
        * Narrowing Cast (Tipo de classe): Quando estamos atribuindo um tipo maior a um tipo menor,
        * precisamos convertê -lo explicitamente.
        * ex.:
        * Product product = new Computer();
        * Computer computer = (computer) product;
        * System.out.println(computer.getName());
        * */
        Product product = new Computer("Ryzen 9", 3000);
        System.out.println(product.getName());
        System.out.println(product.getValue());
        System.out.println(product.calculateTax());

        System.out.println("---------------------");

        Product product2 = new Tomato("Americano", 20);
        System.out.println(product2.getName());
        System.out.println(product2.getValue());
        System.out.println(product2.calculateTax());
    }
}
