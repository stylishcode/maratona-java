package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        /*
         * A LinkedTransferQueue é uma implementação de TransferQueue que permite passar elementos entre threads de
         * forma sincronizada, onde a thread produtora só continua após o elemento ser recebido pela thread consumidora.
         * Ela usa uma lista duplamente ligada para armazenar os elementos e pode ser usada tanto para adicionar quanto
         * para remover elementos em qualquer ordem. Ela é uma junção das funcionalidades de ConcurrentLinkedQueue,
         * SynchronousQueue e LinkedBlockingQueue.
         * */
        TransferQueue<String> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Jiraya"));
        System.out.println(tq.offer("Midoriya"));
        System.out.println(tq.offer("All Might", 10, TimeUnit.SECONDS));
        tq.put("DevDojo");
        if (tq.hasWaitingConsumer()) {
            tq.transfer("Bakugo");
        }
        System.out.println(tq.tryTransfer("Uraraka"));
        System.out.println(tq.tryTransfer("Uraraka", 5, TimeUnit.SECONDS));
        System.out.println(tq.element());
        System.out.println(tq.peek());
        System.out.println(tq.poll());
        System.out.println(tq.take());
        System.out.println(tq.remove());
        System.out.println(tq.remainingCapacity());
    }
}
