package academy.devdojo.maratonajava.javacore.Kenumeracao.test;

import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.Client;
import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.ClientType;
import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.PaymentType;

public class ClientTest01 {
    public static void main(String[] args) {
//        Client.PaymentType.DEBITO e PaymentType.DEBITO são válidos
        Client client1 = new Client("Sendo Takeshi", ClientType.PESSOA_FISICA, PaymentType.DEBITO);
        Client client2 = new Client("Sendo Takeshi", ClientType.PESSOA_JURIDICA, PaymentType.CREDITO);
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(PaymentType.DEBITO.calculateDiscount(100));
        System.out.println(PaymentType.CREDITO.calculateDiscount(100));
    }
}
