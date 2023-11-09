package org.startsteps.week10.class_04;

import java.util.concurrent.CountDownLatch;

public class WorkerThread extends Thread {
    private int id;
    private CountDownLatch latch;

    public WorkerThread(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Worker" + id + " is doing work");

        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Worker " + id + " has completed");

        latch.countDown();
    }
}
