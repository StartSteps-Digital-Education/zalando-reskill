package org.startsteps.week10.class_04;

import java.util.concurrent.Semaphore;

public class SharedResource {
    private static final int MAX_AVAILABLE= 10;
    private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);

    public void useResource(int resourceId) {
        try {
            semaphore.acquire();
            System.out.println("Resource " + resourceId + " acquired" );

            // simulate using the resource
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Resource " + resourceId + " released");
            semaphore.release();
        }
    }
}
