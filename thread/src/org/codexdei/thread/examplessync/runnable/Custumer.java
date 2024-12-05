package org.codexdei.thread.examplessync.runnable;

import org.codexdei.thread.examplessync.Bakery;

public class Custumer implements Runnable{

    private Bakery bakery;

    public Custumer(Bakery bakery) {
        this.bakery = bakery;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++){

            bakery.consumeBread();

    //            try {
    //                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
    //            } catch (InterruptedException e) {
    //                throw new RuntimeException(e);
    //            }
        }
    }
}
