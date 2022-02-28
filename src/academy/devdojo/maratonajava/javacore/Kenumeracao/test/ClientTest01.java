package academy.devdojo.maratonajava.javacore.Kenumeracao.test;

import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.Client;
import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.Client.PaymentType;
import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.ClientType;

public class ClientTest01 {
    public static void main(String[] args) {
//        Client.PaymentType.DEBITO e PaymentType.DEBITO são válidos
        Client client1 = new Client("Sendo Takeshi", ClientType.PESSOA_FISICA, PaymentType.DEBITO);
        Client client2 = new Client("Sendo Takeshi", ClientType.PESSOA_JURIDICA, PaymentType.CREDITO);
        System.out.println(client1);
        System.out.println(client2);
    }
}
