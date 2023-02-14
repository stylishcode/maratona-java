package academy.devdojo.maratonajava.javacore.ZZFthreads.domain;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    /*
    * ArrayBlockingQueue em Java é uma implementação de uma fila de bloqueio, que é uma estrutura de dados
    * comumente usada para sincronizar a comunicação entre threads. Uma fila de bloqueio é uma fila na qual um thread
    * pode bloquear enquanto espera por uma item a ser adicionado ou removido, se a fila estiver vazia ou cheia,
    * respectivamente.
    * */
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        synchronized (emails) {
            return emails.size();
        }
    }

    public void addMemberEmail(String email) {
        synchronized (this.emails) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionou email na lista");
            this.emails.add(email);
            this.emails.notifyAll();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        synchronized (this.emails) {
            // enquanto não tiver email e se tiver aberto, coloca as threads que vão entrando em espera (wait())
            while (this.emails.size() == 0) {
                if (!this.open) break;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera");
                this.emails.wait(); // precisa ter o lock (synchronized) e tratar a exceção
            }
            // retorna e remove o email da fila
            return this.emails.poll();
        }
    }

    public void close() {
        this.open = false;
        synchronized (this.emails) {
            System.out.println(Thread.currentThread().getName() + "Notificando todo mundo que não estamos mais pegando emails");
        }
    }

}
