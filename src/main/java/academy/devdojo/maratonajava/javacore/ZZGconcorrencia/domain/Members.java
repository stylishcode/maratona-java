package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.domain;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    /*
     * ArrayBlockingQueue em Java é uma implementação de uma fila de bloqueio, que é uma estrutura de dados
     * comumente usada para sincronizar a comunicação entre threads. Uma fila de bloqueio é uma fila na qual um thread
     * pode bloquear enquanto espera por uma item a ser adicionado ou removido, se a fila estiver vazia ou cheia,
     * respectivamente.
     * */
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        // obtem o lock
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }
    }

    public void addMemberEmail(String email) {
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.printf(threadName + " adicionou email na lista");
            this.emails.add(email);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        lock.lock();
        try {
            // enquanto não tiver email e se tiver aberto, coloca as threads que vão entrando em espera (wait())
            while (this.emails.size() == 0) {
                if (!this.open) break;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera");
                condition.await();
            }
            // retorna e remove o email da fila
            return this.emails.poll();
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        lock.lock();
        this.open = false;
        try {
            System.out.println(Thread.currentThread().getName() + "Notificando todo mundo que não estamos mais pegando emails");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
