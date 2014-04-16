package me.pogostick29dev.rpg29.map;

import me.pogostick29dev.rpg29.tile.Tile;

public enum MapType {

    OUTSIDE(Tile.GRASS);

    private Tile tile;

    private MapType(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }
}