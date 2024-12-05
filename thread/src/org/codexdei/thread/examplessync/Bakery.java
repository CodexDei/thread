package org.codexdei.thread.examplessync;

public class Bakery {

    private String bread;
    private boolean avaliable = false;

    public synchronized void bake(String dough){

        while (avaliable){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.bread = dough;
        System.out.println("Baker bake:" + this.bread);
        this.avaliable = true;
        notify();
    }

    public synchronized String consumeBread(){

        while (!avaliable){

            try {
                wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }

        System.out.println("Customer consumes bread: " + this.bread);
        this.avaliable = false;
        notify();
        return bread;
    }
}
