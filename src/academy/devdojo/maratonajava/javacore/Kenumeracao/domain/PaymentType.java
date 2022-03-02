package academy.devdojo.maratonajava.javacore.Kenumeracao.domain;

public enum PaymentType {
    DEBITO {
        @Override
        public double calculateDiscount(double value) {
            return value * 0.1; // 10% de desconto
        }
    }, CREDITO {
        @Override
        public double calculateDiscount(double value) {
            return value * 0.05;
        }
    };

    /*
    * Imagine a situação onde é necessário calcular o desconto com base no tipo de compra
    * É possível fazer isso dentro de enumerações, para não ter que ficar fazendo if's no código
    * Para isso é necessário declarar um método abstrato dentro da enumeração e sobrescrevê-lo dentro
    * das enumerações
    * */
    public abstract double calculateDiscount(double value);
}