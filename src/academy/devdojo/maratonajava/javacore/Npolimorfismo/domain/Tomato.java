package academy.devdojo.maratonajava.javacore.Npolimorfismo.domain;

public class Tomato extends Product {
    public static final double TAX_PERCENT = 0.06;
    private String expirationDate;

    public Tomato(String name, double value) {
        super(name, value);
    }

    @Override
    public double calculateTax() {
        System.out.println("Calculando imposto do tomate");
        return this.value * TAX_PERCENT;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
