package org.startsteps.week10.class_04;

public class SemaphoreExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        for(int i = 0; i < 10; i++) {
            Thread thread = new ResourceThread(sharedResource, i);
            thread.start();
        }
    }
}
