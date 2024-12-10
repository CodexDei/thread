package org.codexdei.thread.timerexample;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleTaskTimerExample {

        public static void main(String[] args) {

                Timer timer = new Timer();

                timer.schedule(new TimerTask() {

                        @Override
                        public void run() {

                                System.out.println("It performance the task on " + new Date() + " in the thread: "
                                 + Thread.currentThread().getName());

                                System.out.println("The task is finished");

                                timer.cancel();
                        }
                }, 5000);

                System.out.println("A task is scheduled for 5 more seconds");
        }
}
