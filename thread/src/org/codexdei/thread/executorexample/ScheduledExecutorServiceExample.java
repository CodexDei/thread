package org.codexdei.thread.executorexample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Ejecutando alguna tarea en el main");

        executor.schedule( () -> {

            System.out.println("Tarea programada");

            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 4000, TimeUnit.MILLISECONDS);
        executor.shutdown();

        System.out.println("Otra tarea");
    }
}
