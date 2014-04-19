package me.pogostick29dev.rpg29.map;

import me.pogostick29dev.rpg29.entity.Entity;
import me.pogostick29dev.rpg29.tile.Tile;

import java.awt.*;

public class Location {

    private Tile tile;
    private Point point;
    private Entity entity;

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

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
        if (entity != null && entity.getCurrentLocation() != this) entity.setCurrentLocation(this);
    }
}