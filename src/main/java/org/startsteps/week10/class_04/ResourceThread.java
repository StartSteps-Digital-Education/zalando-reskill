package org.startsteps.week10.class_04;

public class ResourceThread extends Thread {
    private SharedResource resource;
    private int resourceId;


    public ResourceThread(SharedResource resource, int resourceId) {
        this.resource = resource;
        this.resourceId = resourceId;
    }

    @Override
    public void run() {
        resource.useResource(resourceId);
    }
}
