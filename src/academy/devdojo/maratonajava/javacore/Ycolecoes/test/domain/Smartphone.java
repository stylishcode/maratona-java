package academy.devdojo.maratonajava.javacore.Ycolecoes.test.domain;

public class Smartphone {
    private final String SerialNumber;
    private final String brand;

    public Smartphone(String serialNumber, String brand) {
        SerialNumber = serialNumber;
        this.brand = brand;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public String getBrand() {
        return brand;
    }
}
