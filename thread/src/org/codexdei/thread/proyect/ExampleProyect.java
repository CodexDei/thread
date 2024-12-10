package org.codexdei.thread.proyect;

public class ExampleProyect {

    public static void main(String[] args) {

        new Thread(new AlfaNumericoTarea(Tipo.NUMEROS)).start();
        new Thread(new AlfaNumericoTarea(Tipo.LETRAS)).start();
    }
}
