package academy.devdojo.maratonajava.javacore.ZZFthreads;

public class DeadLockTest01 {
    public static void main(String[] args) {
        /*
        * O problema de deadlock é uma situação comum em programação de sistemas concorrentes, onde duas ou
        * mais threads ficam bloqueadas indefinidamente, esperando por recursos que só serão liberados pelas
        * outras threads. Em outras palavras, cada thread precisa de um recurso que está sendo controlado por
        * outra thread, e nenhuma delas consegue prosseguir sem o recurso da outra.
        * Em Java, o deadlock pode ocorrer quando duas ou mais threads tentam acessar simultaneamente recursos
        * compartilhados, como objetos ou variáveis, e ambas entram em uma espera mútua, criando um impasse.
        *
        * O exemplo abaixo está forçando um possível deadlock. Se o terminal ficar "attachado" ao processo, é porque
        * o deadlock ocorreu
        * */
        Object resource1 = new Object();
        Object resource2 = new Object();
        Runnable r1 = () -> {
           synchronized (resource1) {
               System.out.println("Thread 1: Segurando lock 1");
               System.out.println("Thread 1: Esperando lock 2");
               synchronized (resource2) {
                   System.out.println("Thread 1: Segurando lock 2");
               }
           }
        };

        Runnable r2 = () -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: Esperando lock 1");
            }
            synchronized (resource1) {
                System.out.println("Thread 2: Segurando lock 1");
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
