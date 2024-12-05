package org.codexdei.thread.examples;

import org.codexdei.thread.examplessync.runnable.PrintPhrases;

public class ThreadSynchronizationExample{

    public static void main(String[] args) throws InterruptedException {

        new Thread(new PrintPhrases("Hola!", "Que tal?")).start();
        new Thread(new PrintPhrases("bien!", "Gracias")).start();
        new Thread(new PrintPhrases("como va la familia?", "como han estado?")).start();
        new Thread(new PrintPhrases("estamos contentos", "tenemos un bebe")).start();
        new Thread(new PrintPhrases("me alegra", "como se llama?")).start();
        Thread.sleep(500);
        Thread th = new Thread(new PrintPhrases("se llama Samy", "es hermosa!!"));
        th.start();
        Thread.sleep(500);
        System.out.println(th.getState());


    }
    //se usa synchronized para que las frases que ingresan POR CADA HILO se impriman en orden
    public synchronized static void showMessage(String message1, String message2){

        System.out.println(message1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(message2);

    }
}
