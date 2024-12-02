package org.codexdei.thread.examples;

import org.codexdei.thread.examples.threads.NameThread;

public class ExampleExtendThread {

    public static void main(String[] args) throws InterruptedException {

        Thread joseHilo = new NameThread("JOSE");
        Thread mariaHilo = new NameThread("MARIA");
        Thread pepeHilo = new NameThread("PEPE");

        System.out.println("JOSE STATUS: " + joseHilo.getState());
        joseHilo.start();
        //Thread.sleep(1000);

        System.out.println("MARIA STATUS: " + mariaHilo.getState());
        mariaHilo.start();
        //Thread.sleep(1000);

        System.out.println("PEPE STATUS: " + joseHilo.getState());
        pepeHilo.start();
        //Thread.sleep(1000);
    }
}