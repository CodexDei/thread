package org.codexdei.thread.examples.runnable;

import org.codexdei.thread.examples.ThreadSynchronizationExample;

import static org.codexdei.thread.examples.ThreadSynchronizationExample.showMessage;

public class PrintPhrases implements Runnable{

    private String phrase1;
    private String phrase2;

    public PrintPhrases(String phrase1, String phrase2){

        this.phrase1 = phrase1;
        this.phrase2 = phrase2;
    }

    @Override
    public void run() {

        showMessage(phrase1,phrase2);
    }
}
