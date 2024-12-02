package org.codexdei.thread.examples.threads;

public class NameThread extends Thread{

    public NameThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println("Se INICIA el hilo: " + getName());

            for (int i = 0; i < 10; i++){

                System.out.println(this.getName());
            }
        System.out.println("Se TERMINA el hilo: " + getName());
    }
}
