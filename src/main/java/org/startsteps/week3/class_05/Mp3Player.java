package org.startsteps.week3.class_05;

public class Mp3Player implements AudioPlayer {

    @Override
    public void play() {
        System.out.println("Playing mp3 audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing mp3 audio");
    }

    @Override
    public void stop() {
        System.out.println("Stopping mp3 audio");
    }
}
