package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPricesAsyncCompletableFuture(storeService);
    }

    public static void searchPricesAsyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        /*
        O problema em combinar operações preguiçosas de Java Streams com CompletableFuture é que a execução assíncrona
        e não bloqueante de uma operação preguiçosa pode ser interrompida ou bloqueada por uma operação final em Java
        Streams, como collect. Por exemplo, se uma operação collect for usada para coletar todos os elementos de uma
        stream, ela bloqueará a execução assíncrona das operações preguiçosas anteriores, o que pode afetar
        negativamente o desempenho e a escalabilidade do programa.
         */
//        List<Double> prices = stores.stream()
//                .map(storeService::getPricesAsyncCompletableFuture)
//                .map(CompletableFuture::join)
//                .toList();

        /*
        Para evitar esse problema, é recomendável usar apenas operações preguiçosas em Java Streams quando trabalhando
        com CompletableFuture. Quando uma operação final for necessária, é melhor executá-la depois que todas as
        operações preguiçosas forem concluídas.
         */
        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(storeService::getPricesAsyncCompletableFuture)
                .toList();
        List<Double> prices = completableFutures.stream().map(CompletableFuture::join).toList();
        System.out.println(prices);

        long end = System.currentTimeMillis();
        System.out.printf("Time taken by this operation: %dms%n", (end - start));
    }
}
