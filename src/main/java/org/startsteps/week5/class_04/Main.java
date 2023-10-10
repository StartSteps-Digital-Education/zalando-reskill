package org.startsteps.week5.class_04;

public class Main {
    public static void main(String[] args) {
        ArtistManager artistManager = new ArtistManager();

        MusicArtist artistA = new MusicArtist();
        artistA.setName("Kayla");

        MusicArtist artistB = new MusicArtist();
        artistA.setName("Winta");

        artistManager.add(artistA);
        artistManager.add(artistB);

        Artist foundArtist = artistManager.searchArtist("Bob Dylan");

        if (foundArtist != null) {
            System.out.println("Found artist: " + foundArtist.getName());
        } else {
            System.out.println("Artist not found.");
        }
    }
}
