package academy.devdojo.maratonajava.javacore.Kenumeracao.domain;

public class Client {
    // apesar de não ser tão organizado, é possível criar enumerações dentro de classes

    private String name;
    private ClientType clientType;
    /*
        Se o tipo não tiver um modificador de acesso, por padrão ele será acessado por
        qualquer classe que esteja no mesmo pacote
     */
    private PaymentType paymentType;

    public Client(String name, ClientType clientType, PaymentType paymentType) {
        this.name = name;
        this.clientType = clientType;
        this.paymentType = paymentType;
    }


    @Override
    public String toString() {
        return "Client: { " +
                "name='" + name + '\'' + " " +
                ", clientType=" + clientType.REPORTNAME + " " +
                ", clientTypeValue=" + clientType.VALUE + " " +
                ", PaymentType=" + paymentType + " " +
                '}';
    }
}
