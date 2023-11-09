package org.startsteps.week10.class_04;

public class BarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("All workers have reached the barrier. Barrier action is executed");
    }
}
