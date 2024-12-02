    package org.codexdei.thread.examples;

import org.codexdei.thread.examples.runnable.TaskTrip;

public class ExampleImplementRunnableJava8 {

    public static void main(String[] args) {

      //Se usa una expesion lampda para no tener que colocar de manera explicita el metodo run()
        Runnable viaje = () -> {

                for(int i = 0; i < 10; i++){

                    System.out.println( (i + 1) + "-" + Thread.currentThread().getName()
                                        + " - " + Thread.currentThread().getPriority());

                    try {
                        Thread.sleep( (long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Finalmente me voy de viaje para: " + Thread.currentThread().getName());

            };

            new Thread(viaje,"Jerusalem").start();
            new Thread(viaje,"Japon").start();
            new Thread(viaje,"Paris").start();
            new Thread(viaje,"New York").start();
            new Thread(viaje,"Egipto").start();
        }
}


