    package org.codexdei.thread.executorexample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServicePeriodExample {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Ejecutando alguna tarea en el main");

        executor.scheduleAtFixedRate( () -> {

            System.out.println("Tarea programada");

        }, 0, 2000, TimeUnit.MILLISECONDS);
        executor.schedule(executor::shutdown,20,TimeUnit.SECONDS);

        System.out.println("Otra tarea");
    }
}
