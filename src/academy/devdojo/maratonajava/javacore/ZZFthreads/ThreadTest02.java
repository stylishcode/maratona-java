package academy.devdojo.maratonajava.javacore.ZZFthreads;

class ThreadExampleRunnable2 implements Runnable {
    private final String s;

    public ThreadExampleRunnable2(String s) {
        this.s = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(s);
            if (i % 100 == 0) {
                System.out.println();
            }
            // Uma dica para o scheduler de que a thread atual está disposta a ceder seu uso atual de um processador.
            // O scheduler é livre para ignorar esta dica.
//            Thread.yield();
        }
    }
}

public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadExampleRunnable2("KA"));
        Thread t2 = new Thread(new ThreadExampleRunnable2("ME"));
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        // como é a thread main que está criando e iniciando as threads, ela que faz a chamada
        // thread main chama o método t1.join() para esperar a thread t1 terminar sua execução
        t1.join(); // espera essa thread morrer
        t2.start();
    }
}
