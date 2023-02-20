package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.domain.Discount;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.domain.Quote;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServiceWithDiscount {

    // precisamos retornar nesse padrão: storeName:price:discountCode
    public String getPriceSync(String storeName) {
        // poderia vir de uma chamada a um servidor remoto por ex
        double price = priceGenerator();
        // pega um valor aleatório da enumeração (que poderia vir do banco de dados por ex)
        Discount.Code discountCode = Discount.Code
                .values()[ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", storeName, price, discountCode);
    }

    private double priceGenerator() {
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    public String applyDiscount(Quote quote) {
        // simulando que para aplicar um desconto, é necessário fazer outra chamada em outro serviço
        delay();
        // Como pode gerar um desconto 0. Fazemos essa formula para que retorne 1 quando não tiver desconto
        double discountValue = quote.getPrice() * (100 - quote.getDiscountCode().getPercentage()) / 100;
        return String.format("'%s' original price: '%.2f'. Applying discount code '%s'. Final price: '%.2f'",
                quote.getStore(), quote.getPrice(), quote.getDiscountCode(), discountValue);
    }

    private void delay() {
        try {
            int milli = ThreadLocalRandom.current().nextInt(200, 2500);
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
