package academy.devdojo.maratonajava.javacore.Jmodificadorfinal.domain;

public class Car {
    private String nome;
    public static final double MAX_SPEED = 250;
    // A referência para o objeto não pode ser alterada. Mas os valores dentro do objeto sim
    // Como os const object = {} do javascript
    public final Buyer BUYER = new Buyer();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
