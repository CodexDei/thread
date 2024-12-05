package org.codexdei.thread.examples;

import org.codexdei.thread.examplessync.Bakery;

import java.util.concurrent.ThreadLocalRandom;

public class BakerCustumerExampleLampdaJava8 {

    public static void main(String[] args) {

        Bakery b = new Bakery();

        new Thread( () -> {

            for (int i = 0; i < 10; i++) {

                b.bake("Bread # " + (i + 1));

                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread( () -> {

            for (int i = 0; i < 10; i++){

                b.consumeBread();

                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

}
