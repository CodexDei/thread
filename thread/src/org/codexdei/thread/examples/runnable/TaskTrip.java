package org.codexdei.thread.examples.runnable;

public class TaskTrip implements Runnable{

    String nombre;

    public TaskTrip(String nombre){

        this.nombre = nombre;
    }

    public String getNombre(){

        return nombre;
    }

    @Override
    public void run() {

        for(int i = 0; i < 10; i++){

            System.out.println( (i + 1) + "-" + this.nombre);

            try {
                Thread.sleep( (long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finalmente me voy de viaje para: " + nombre);
    }
}
