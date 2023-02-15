package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        // adquire o lock se outra thread não estiver segurando e define a contagem de holdLock em 1
        // caso a thread que esteja obtendo esse lock já estiver segurando ele, a contagem é incrementada em 1
        lock.lock();
        try {
            // verifica se a thread que está executando esse código tem o lock
            // essa verificação é para mostrar que existe algo assim, mas nesse exemplo não é necessária
           if (lock.isHeldByCurrentThread()) {
               // sessão crítica porque é uma sessão dentro do lock
               System.out.printf("Thread %s entrou em uma sessão crítica%n", name);
           }
            // retorna um número estimado de threads que estão esperando para obter o lock
            System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength());
            System.out.printf("Thread %s vai esperar 2s%n", name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera%n", name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // sempre vai liberar o lock
            lock.unlock();
        }
    }
}

public class ReentrantLockTest01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }
}
