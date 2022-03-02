package academy.devdojo.maratonajava.javacore.Kenumeracao.test;

import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.Customer;
import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.CustomerType;
import academy.devdojo.maratonajava.javacore.Kenumeracao.domain.PaymentType;

public class CustomerTest01 {
    public static void main(String[] args) {
//        Customer.PaymentType.DEBITO e PaymentType.DEBITO são válidos
        Customer client1 = new Customer("Sendo Takeshi", CustomerType.PESSOA_FISICA, PaymentType.DEBITO);
        Customer client2 = new Customer("Sendo Takeshi", CustomerType.PESSOA_JURIDICA, PaymentType.CREDITO);
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(PaymentType.DEBITO.calculateDiscount(100));
        System.out.println(PaymentType.CREDITO.calculateDiscount(100));
        CustomerType customerType = CustomerType.getByReportValue("Pessoa Física");
        System.out.println(customerType);
    }
}
