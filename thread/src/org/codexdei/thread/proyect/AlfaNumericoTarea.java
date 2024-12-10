package org.codexdei.thread.proyect;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AlfaNumericoTarea implements Runnable{

    Tipo tipo;

    public AlfaNumericoTarea(Tipo tipo){

        this.tipo = tipo;
    }
    public Tipo getTipo(){
        return this.tipo;
    }

    @Override
    public void run() {

        if (tipo == Tipo.NUMEROS){

                for (int i = 1; i < 10; i++){

                    System.out.println( (i) );
                }

        } else if (tipo == Tipo.LETRAS) {

                for (char letter = 'A'; letter <= 'Z'; letter++){

                    System.out.println( letter );
                }
        }
    }
}
