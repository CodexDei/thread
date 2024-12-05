package org.codexdei.thread.examples;

import org.codexdei.thread.examplessync.runnable.Baker;
import org.codexdei.thread.examplessync.runnable.Custumer;
import org.codexdei.thread.examplessync.Bakery;

public class BakerCustumerExample {

    public static void main(String[] args) {

        Bakery b = new Bakery();

        new Thread(new Baker(b)).start();
        new Thread(new Custumer(b)).start();
    }
}
