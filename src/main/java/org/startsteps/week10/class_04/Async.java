package org.startsteps.week10.class_04;

import java.util.concurrent.CountDownLatch;

public class Async {

    public static void main(String[] args) {
        // threads more than one (multiple threads) to sync together
        // CountdownLatch -wait set operations to complete before processing

        int numberOfThreads = 3;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for(int i = 0; i < numberOfThreads; i++) {
            Thread workerThread = new WorkerThread(i, latch);
            workerThread.start();
        }

        try {
            latch.await();
            System.out.println("All worker threads finished work.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
