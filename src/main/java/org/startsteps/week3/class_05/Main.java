package org.startsteps.week3.class_05;

public class Main {
    public static void main(String[] args) {
        AudioPlayer mp3Player = new Mp3Player();
        AudioPlayer wavPlayer = new WavPlayer();


        // credit card = pay() {}, klarna = pay() {}

        // Play, pause, and stop audio using both players
        System.out.println("MP3 Player:");
        mp3Player.play();
        mp3Player.pause();
        mp3Player.stop();
        System.out.println();

        System.out.println("WAV Player:");
        wavPlayer.play();
        wavPlayer.pause();
        wavPlayer.stop();
    }
}
