package me.pogostick29dev.rpg29.tile;

import javax.swing.*;

public enum Tile {

    EMPTY,

    GRASS("G", 1, 1, Layer.BELOW),

    WATER_VERTICAL("WV", 1, 2, Layer.ON),

    WATER_HORIZONTAL("WH", 1, 3, Layer.ON);

    private Tilesheet environment;

    private String id;
    private ImageIcon image;
    private Layer layer;

    private Tile(String id, int x, int y, Layer layer) {
        if (environment == null) environment = new Tilesheet("environment");

        this.id = id;
        this.image = environment.getTile(x - 1, y - 1);
        this.layer = layer;
    }

    private Tile() {
        this.id = "E";
    }

    public static Tile byID(String id) {
        for (Tile t : Tile.values()) {
            if (t.getID().equals(id)) return t;
        }

        return null;
    }

    public String getID() {
        return id;
    }

    public Layer getLayer() {
        return layer;
    }

    public ImageIcon getImage() {
        return image;
    }
}