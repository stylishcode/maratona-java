package academy.devdojo.maratonajava.javacore.Npolimorfismo.domain;

public class Tomato extends Product {
    public static final double TAX_PERCENT = 0.06;
    public Tomato(String name, double value) {
        super(name, value);
    }

    @Override
    public double calculateTax() {
        System.out.println("Calculando imposto do tomate");
        return this.value * TAX_PERCENT;
    }
}
