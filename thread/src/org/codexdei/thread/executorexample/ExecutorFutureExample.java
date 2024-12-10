package org.codexdei.thread.executorexample;

import java.util.concurrent.*;

public class ExecutorFutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        //A diferencia del Runnable devuelve un resultado, Runnable no devuelve nada
        Callable<String> task = () -> {

            System.out.println("The task is started");
            System.out.println("Name task: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Task finished");

            return "RESULT IMPORTANT!!!";
        };
        Future<String> result= executor.submit(task);
        //detener la ejecucion de tareas,sino continuaria el programa y quedaria en espera
        executor.shutdown();
        System.out.println("Continuing with the executed");

        while (!result.isDone()){
            System.out.println("Executing task");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println("Obtain the result of the task: " + result.get());
        System.out.println("Task completed:" + result.isDone());
    }
}
