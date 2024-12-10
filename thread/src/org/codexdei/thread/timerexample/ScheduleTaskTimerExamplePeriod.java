package org.codexdei.thread.timerexample;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleTaskTimerExamplePeriod {

        public static void main(String[] args) {

                //reproduce un sonido cada vez que se efectua una tarea
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                //funciona como contador para detener el run()
                AtomicInteger counter =  new AtomicInteger(3);

                Timer timer = new Timer();

                timer.schedule(new TimerTask() {

                        @Override
                        public void run() {

                                int i = counter.getAndDecrement();

                        if(i > 0) {

                                toolkit.beep();

                                System.out.println("Task period '" + i + "' date: '" + new Date() + "' in the thread: "
                                        + Thread.currentThread().getName());
                        }else {
                                System.out.println("The task '" + i + "' is finished");
                                timer.cancel();
                        }
                //delay: es el tiempo antes de empezar period: por cada tarea
                        }
                }, 5000,10000);

                System.out.println("A task is scheduled for 5 more seconds");
        }
}
