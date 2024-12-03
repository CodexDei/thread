package org.codexdei.thread.examples;

public class ExampleImplementRunnableJoin {

    public static void main(String[] args) throws InterruptedException {

            Thread main = Thread.currentThread();

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
            System.out.println("Hilo main: " + main.getState());

        };

        Thread v1 = new Thread(viaje,"Jerusalem");
        Thread v2 = new Thread(viaje,"Japon");
        Thread v3 = new Thread(viaje,"Paris");
        Thread v4 = new Thread(viaje,"New York");
        Thread v5 = new Thread(viaje,"Egipto");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v5.start();

        v1.join();
        v2.join();
        v3.join();
        v4.join();
        v5.join();

        System.out.println("Continuando con el hilo: " + main.getState());
    }
}
