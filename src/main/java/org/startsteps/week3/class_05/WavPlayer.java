package org.startsteps.week3.class_05;

public class WavPlayer implements AudioPlayer {
    @Override
    public void play() {
        System.out.println("Playing WAV audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing WAV audio");
    }

    @Override
    public void stop() {
        System.out.println("Stopping WAV audio");
    }
}
