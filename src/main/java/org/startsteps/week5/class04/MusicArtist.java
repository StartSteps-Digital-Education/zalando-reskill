package org.startsteps.week5.class04;

public class MusicArtist implements Artist {
    private String name;

    @Override
    public String getName() {
        return (name != null) ? name : "";
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
