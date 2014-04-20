package me.pogostick29dev.rpg29.audio;

public enum Music {

    VILLAGE("village");

    private String path;

    Music(String path) {
        this.path = "audio/music/" + path + ".mp3";
    }

    public String getPath() {
        return path;
    }
}