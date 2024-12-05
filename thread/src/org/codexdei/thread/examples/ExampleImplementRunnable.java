package org.codexdei.thread.examples;

import org.codexdei.thread.examplessync.runnable.TaskTrip;

public class ExampleImplementRunnable {

    public static void main(String[] args) {

            new Thread(new TaskTrip("Jerusalem")).start();
            new Thread(new TaskTrip("Paris")).start();
            new Thread(new TaskTrip("New York")).start();
            new Thread(new TaskTrip("Londres")).start();
            new Thread(new TaskTrip("Japon")).start();
        }
}


