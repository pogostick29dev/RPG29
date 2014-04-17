package me.pogostick29dev.rpg29.map;

import me.pogostick29dev.rpg29.tile.Tile;

import java.awt.*;

public class Location {

    private Tile tile;
    private Point point;

    public Location(String raw, int row, int column) {
        this.tile = Tile.byID(raw);
        this.point = new Point(row, column);
    }

    public Tile getTile() {
        return tile;
    }

    public Point getPoint() {
        return point;
    }
}