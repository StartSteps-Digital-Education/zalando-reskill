package org.startsteps.week5.class_04;

import java.util.ArrayList;
import java.util.List;

public class ArtistManager {
    List<Artist> artists = new ArrayList<>();

    public void add(Artist artist) {
        artists.add(artist);
    }

    public void remove(Artist artist) {
        artists.remove(artist);
    }

    public Artist searchArtist(String name) {
        for (Artist artist : artists) {
            if (artist.getName().equals(name)) {
                return artist;
            }
        }

        return null;
    }
}
