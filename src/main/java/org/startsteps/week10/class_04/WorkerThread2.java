package org.startsteps.week10.class_04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WorkerThread2 extends Thread {
    private int id;
    private CyclicBarrier barrier;

    public WorkerThread2(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("Worker" + id + " is ready.");

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Worker " + id + " has started working.");
    }
}
