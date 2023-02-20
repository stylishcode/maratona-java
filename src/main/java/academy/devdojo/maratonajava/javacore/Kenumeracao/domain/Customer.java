package academy.devdojo.maratonajava.javacore.Kenumeracao.domain;

public class Customer {
    // apesar de não ser tão organizado, é possível criar enumerações dentro de classes

    private String name;
    private CustomerType customerType;
    /*
        Se o tipo não tiver um modificador de acesso, por padrão ele será acessado por
        qualquer classe que esteja no mesmo pacote
     */
    private PaymentType paymentType;

    public Customer(String name, CustomerType clientType, PaymentType paymentType) {
        this.name = name;
        this.customerType = clientType;
        this.paymentType = paymentType;
    }


    @Override
    public String toString() {
        return "Customer: { " +
                "name='" + name + '\'' + " " +
                ", customerType=" + customerType.REPORTVALUE + " " +
                ", customerTypeValue=" + customerType.VALUE + " " +
                ", PaymentType=" + paymentType + " " +
                '}';
    }
}
