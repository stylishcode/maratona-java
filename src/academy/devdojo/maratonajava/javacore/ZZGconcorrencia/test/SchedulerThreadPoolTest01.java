package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SchedulerThreadPoolTest01 {
    private static final ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper() {
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        // executa o runnable 1 vez, depois de 5 segundos (não encerra o programa)
//        executor.schedule(r, 5, TimeUnit.SECONDS);
        // executa o runnable a partir de 1s, de 5 em 5s
        // fixedDelay: se a thread dorme, assim que ela acorda ele executa, então o delay vai ser sleep + delayTime
        ScheduledFuture<?> scheduledWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 2, TimeUnit.SECONDS);
        // fixedRate: independente da thread dormir, sempre vai ser executado depois do delayTime
//        ScheduledFuture<?> scheduledAtFixedRate = executor.scheduleAtFixedRate(r, 1, 2, TimeUnit.SECONDS);
        // executa o runnable que é parar o scheduler acima depois de 10s
        executor.schedule(() -> {
            System.out.println("Cancelando o scheduleWithFixedDelay");
            // false -> só interrompe o scheduler depois que a tarefa é concluida
            scheduledWithFixedDelay.cancel(false);
            // desliga o executor service
            executor.shutdown();
        }, 20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter) + " beep");
        beeper();
    }
}
