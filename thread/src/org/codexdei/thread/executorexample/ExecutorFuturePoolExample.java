package org.codexdei.thread.executorexample;

import java.util.concurrent.*;

public class ExecutorFuturePoolExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //Crea un hilo para cada tarea buscando asegurar que terminen al tiempo, no es 100% seguro
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //A diferencia del Runnable devuelve un resultado, Runnable no devuelve nada
        Callable<String> task = () -> {

            System.out.println("The task 1 is started");
            System.out.println("Name task 1: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Task 1 finished");

            return "RESULT IMPORTANT TASK 1!!!";
        };

        Callable<Integer> task2 = () -> {

            System.out.println("The task 2 is started");
            System.out.println("Name task 2: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Task 2 finished");

            return 10;
        };

        Callable<Double> task3 = () -> {

            System.out.println("The task 3 is started");
            System.out.println("Name task 3: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Task 3 finished");

            return 7.777;
        };

        Future<String> result= executor.submit(task);
        Future<Integer> result2= executor.submit(task2);
        Future<Double> result3= executor.submit(task3);
        //detener la ejecucion de tareas,sino continuaria el programa y quedaria en espera
        executor.shutdown();
        System.out.println("Continuing with the execution");

        while (!result.isDone() && !result2.isDone() && !result3.isDone()){

            System.out.println(String.format("Result 1: %s - Result 2: %s - Result 3: %s",
                                result.isDone() ? "In process task 1" : "Finish task 1",
                                result2.isDone() ? "In process task 2" : "Finish task 2",
                                result3.isDone() ? "In process task 3" : "Finish task 3"
            ));
            TimeUnit.SECONDS.sleep(5);
        }
        System.out.println("Obtain the result of the task 1: " + result.get());
        System.out.println("Task completed task 1:" + result.isDone());

        System.out.println("Obtain the result of the task 2: " + result2.get());
        System.out.println("Task completed task 2:" + result2.isDone());

        System.out.println("Obtain the result of the task 3: " + result3.get());
        System.out.println("Task completed:" + result3.isDone());
    }
}
