package academy.devdojo.maratonajava.javacore.Kenumeracao.test;

import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.Client;
import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.ClientType;

public class ClientTest01 {
    public static void main(String[] args) {
        Client client1 = new Client("Sendo Takeshi", ClientType.PESSOA_FISICA);
        Client client2 = new Client("Sendo Takeshi", ClientType.PESSOA_FISICA);
        Client client3 = new Client("Sendo Takeshi", ClientType.PESSOA_FISICA);
        Client client4 = new Client("Sendo Takeshi", ClientType.PESSOA_JURIDICA);
        Client client5 = new Client("Sendo Takeshi", ClientType.PESSOA_JURIDICA);
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);
        System.out.println(client4);
        System.out.println(client5);
    }
}
