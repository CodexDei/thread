package org.codexdei.thread.executorexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {

            System.out.println("The task is started");
            System.out.println("Name task: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Task finished");
        };
        executor.submit(task);
        //detener la ejecucion de tareas,sino continuaria el programa y quedaria en espera
        executor.shutdown();
        System.out.println("Continuing task 1");
        //coloca en espera el hilo principal hasta que terminen todas las tareas o trancurran en este caso 20 segundos
        executor.awaitTermination(20,TimeUnit.SECONDS);
        System.out.println("Continuing task 2");
    }
}
