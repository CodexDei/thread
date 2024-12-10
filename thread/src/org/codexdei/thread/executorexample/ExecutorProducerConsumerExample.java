package org.codexdei.thread.executorexample;

import org.codexdei.thread.examplessync.Bakery;
import org.codexdei.thread.examplessync.runnable.Baker;
import org.codexdei.thread.examplessync.runnable.Custumer;

import java.util.concurrent.*;

public class ExecutorProducerConsumerExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //Maneja un grupo de hilos que se reutilizan para ejecutar tareas.
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Pool size: " + executor.getPoolSize());
        System.out.println("Number of tasks in queue: " + executor.getQueue().size());

        Bakery b = new Bakery();

        Runnable baker = new Baker(b);
        Runnable custumer = new Custumer(b);
        //Representa el resultado de una tarea asíncrona.
        Future<?> result = executor.submit(custumer);
        Future<?> result2 = executor.submit(baker);

        System.out.println("Number pool: " + executor.getPoolSize());
        System.out.println("Number of tasks in queue: " + executor.getQueue().size());
        //detener la ejecucion de tareas,sino continuaria el programa y quedaria en espera
        executor.shutdown();
        System.out.println("Continuing with the execution");

    }
}
