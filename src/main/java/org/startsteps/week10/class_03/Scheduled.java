package org.startsteps.week10.class_03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduled {
    public static void main(String[] args) {
        // ScheduledExecutorService - periodically or once time after delay

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        Runnable task2 = () -> System.out.println("Running task 2...");
        Runnable task5 = () -> System.out.println("Running task 5...");

        task1();

        ses.schedule(task2, 5, TimeUnit.SECONDS);
        ses.schedule(task5, 5, TimeUnit.SECONDS);

        task3();

        ses.shutdown();
    }

    public static void task1() {
        System.out.println("Running task 1 ....");
    }

    public static void task3() {
        System.out.println("Running task 3 ....");
    }
}
