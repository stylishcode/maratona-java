package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();
        searchPricesAsyncCompletableFuture(storeServiceDeprecated);
    }

    public static void searchPricesAsyncCompletableFuture(StoreServiceDeprecated storeService) {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        List<CompletableFuture<Double>> completableFutures = stores.stream()
//                .map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s)))
                // será executado com 3 threads
                .map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s), executor))
                .toList();

        List<Double> prices = completableFutures.stream().map(CompletableFuture::join).toList();

        System.out.println(prices);
        long end = System.currentTimeMillis();
        // como passamos um executor para o supplyAsync, precisamos desligar, porque ele está usando executor e não
        // mais o ForkJoinPool
        executor.shutdown();
        System.out.printf("Time taken by this operation: %dms%n", (end - start));
    }
}
