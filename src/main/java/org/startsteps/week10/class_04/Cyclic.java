package org.startsteps.week10.class_04;

import java.util.concurrent.CyclicBarrier;

public class Cyclic {
    //

    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, new BarrierAction());

        for(int i=0 ; i < numberOfThreads; i++) {
            Thread workerThread = new WorkerThread2(i, barrier);
            workerThread.start();
        }
    }
}
