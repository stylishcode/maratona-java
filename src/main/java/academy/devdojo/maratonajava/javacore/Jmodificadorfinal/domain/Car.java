package academy.devdojo.maratonajava.javacore.Jmodificadorfinal.domain;

public class Car {
    private String name;
    public static final double MAX_SPEED = 250;
    // A referência para o objeto não pode ser alterada. Mas os valores dentro do objeto sim
    // Como os const object = {} do javascript
    public final Buyer BUYER = new Buyer();

    // Método nunca poderá ser sobrescrito nas classes que o herdam
    public final void print() {
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
