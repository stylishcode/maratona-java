package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        // Math.random() é sincronizado
        // Para multithreading e gerar um valor aleatório para cada thread, use ThreadLocalRandom
        int num = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < num; i++) {
            System.out.printf("%s executando uma tarefa callable...%n", Thread.currentThread().getName());
        }
        return String.format("%s finished and the random number is %d", Thread.currentThread().getName(), num);
    }
}

public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // Envia uma tarefa Runnable para execução e retorna um Future representando essa tarefa.
        // O método get do Future retornará nulo após a conclusão bem-sucedida.
        Future<String> future = executorService.submit(randomNumberCallable);
        //Aguarda (faz a thread main esperar), se necessário, a conclusão do cálculo e, em seguida, recupera seu resultado.
        String s = future.get();
        System.out.printf("Program finished %s", s);
        executorService.shutdown();
    }
}
