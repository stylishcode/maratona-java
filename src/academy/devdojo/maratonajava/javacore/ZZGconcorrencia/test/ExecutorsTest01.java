package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable {
    private final int num;

    public Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s iniciou: %d%n",Thread.currentThread().getName(), num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finalizou %n", Thread.currentThread().getName());
    }
}

public class ExecutorsTest01 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(4); // numero fixo de threads
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 1 thread
        // cria novas threads se precisa, mas reutiliza as existentes se estiverem disponiveis
        ExecutorService executorService = Executors.newCachedThreadPool();
        // não estamos executando a thread. A responsabilidade vai ser do Executor
        // 4 threads irão trabalhar somente
        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4));
        // Como definimos fixamente 4 threads. As threads acima que liberarem pegarão o trabalho abaixo
        // assim que ficarem disponíveis, no futuro (forma assincrona)
        executorService.execute(new Printer(6));
        executorService.execute(new Printer(7));
        // Inicia um desligamento ordenado no qual as tarefas enviadas anteriormente são executadas, mas nenhuma
        // nova tarefa será aceita.
        executorService.shutdown();
        // Isso aqui será executado primeiro, porque o Executor ainda vai finalizar as threads (se estiverem executando)
        System.out.println("Programa finalizou");
    }
}
