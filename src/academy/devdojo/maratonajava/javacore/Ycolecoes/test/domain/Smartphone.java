package academy.devdojo.maratonajava.javacore.Ycolecoes.test.domain;

public class Smartphone {
    private final String serialNumber;
    private final String brand;

    public Smartphone(String serialNumber, String brand) {
        this.serialNumber = serialNumber;
        this.brand = brand;
    }

    /*
    * (1) Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
    * (2) Simétrico: para x e y diferentes de null, se x.equals(y) == true, logo y.equals(x) == true
    * (3) Transitividade: para x,y,z diferentes de null, se x.equals(y) == true e y.equals(x) == true, logo y.equals(z) == true
    * (4) Consistente: x.equals(x) sempre retorna true se x for diferente de null
    * (5) para x diferente de null, x.equals(null) tem que retornar false
    * */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }
}
