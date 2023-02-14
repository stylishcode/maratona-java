package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

/*
* Essa não é uma forma muito indicada de criar threads, pois quando trabalhamos com herança estamos falando que estamos
* especializando uma classe e aqui não estamos especializando a classe Thread
* */
class ThreadExample extends Thread {
    private final char c;

    public ThreadExample(char c) {
        this.c = c;
    }

    @Override
    // código a ser executado por essa thread
    public void run() {
        System.out.println(Thread.currentThread().getName()); // nome da thread
        for (int i=0; i<500; i++) {
            System.out.print(c); // imprime o caractere
            if (i%100 == 0) {
                System.out.println(); // quebra a linha para melhorar a visualização
            }
        }
    }
}

class ThreadExampleRunnable implements Runnable {
    private final char c;

    public ThreadExampleRunnable(char c) {
        this.c = c;
    }

    @Override
    // código a ser executado por essa thread
    public void run() {
        System.out.println(Thread.currentThread().getName()); // nome da thread
        for (int i=0; i<500; i++) {
            System.out.print(c); // imprime o caractere
            if (i%100 == 0) {
                System.out.println(); // quebra a linha para melhorar a visualização
            }
            try {
                Thread.sleep(2000); // bloqueia a thread (faz ela dormir) por 2 seg
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadTest01 {
    public static void main(String[] args) {
        /*
         * Uma thread (fio/linha) é um thread (fio/linha) de execução em um programa. A JVM permite que um aplicativo
         * tenha vários encadeamentos de execução em execução simultaneamente.
         *
         * Cada thread tem uma prioridade. Threads com prioridade mais alta são executados preferencialmente a threads
         * com prioridade mais baixa. Cada thread pode ou não ser marcada como um daemon. Quando o código em execução
         * em alguma thread cria um novo objeto Thread, a nova thread tem sua prioridade inicialmente definida igual à
         * prioridade da thread de criação e é uma daemon thread se e somente se a thread de criação for um daemon.
         *
         * Quando a JVM é inicializada, geralmente há uma única thread não-daemon (que normalmente chama o método main()
         * de alguma classe designada). A JVM continua a executar threads até que ocorra uma das seguintes situações:
         *   - O método exit() da classe Runtime foi chamado e o gerenciador de segurança permitiu que a operação de
         *     saída ocorresse.
         *
         *   - Todas as threads que não são daemon threads morreram, retornando da chamada para o método run() ou
         *     lançando uma exceção que se propaga além do método run().
         *
         *
         * Há duas formas de criar uma thread de execução. Uma é declarar uma classe para ser subclasse de
         * java.lang.Thread. Essa subclasse deve sobrescrever o método run() da mesma. Uma
         * instância da subclasse deve ser alocada e iniciada.
         *
         * Toda thread tem um nome e esse nome pode ser obtido usando o método Thread.currentThread().getName()
         * */

        // "main" não tem a ver com o método main, mas sim com o nome da thread que inicia uma aplicação Java
        // System.out.println(Thread.currentThread().getName()); // main

        // Criando threads (não estão iniciadas)
//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');

        // se você chamar o método run(), o código continuará sendo executado em uma única thread. O método precisa ser o start()
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        // Criando threads com Runnable (orientado a interface) (não estão iniciadas)
        // O construtor de Thread aceita receber um nome para ela, caso contrário gera
        Thread t1 = new Thread(new ThreadExampleRunnable('A'), "T1A");
        Thread t2 = new Thread(new ThreadExampleRunnable('B'), "T2B");
        Thread t3 = new Thread(new ThreadExampleRunnable('C'), "T3C");
        Thread t4 = new Thread(new ThreadExampleRunnable('B'), "T4D");

        // prioridade da Thread (não é garantido que a thread executará primeiro, é apenas um indicador)
        t4.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
