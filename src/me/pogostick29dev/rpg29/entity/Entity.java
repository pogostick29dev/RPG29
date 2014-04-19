package me.pogostick29dev.rpg29.entity;

import me.pogostick29dev.rpg29.map.Direction;
import me.pogostick29dev.rpg29.map.Location;
import me.pogostick29dev.rpg29.tile.Tilesheet;

import javax.swing.*;
import java.util.HashMap;

public class Entity {

    private HashMap<Direction, HashMap<Integer, ImageIcon>> images;
    private HashMap<Direction, Integer> walkCycle;
    private ImageIcon currentImage;
    private Direction currentDirection;
    private Location currentLocation;

    public Entity(String name) {
        images = new HashMap<Direction, HashMap<Integer, ImageIcon>>();
        walkCycle = new HashMap<Direction, Integer>();

        Tilesheet t = new Tilesheet("sprites/" + name.toLowerCase() + "/tilesheet");

        addImages(Direction.LEFT, t.getTile(1, 1), t.getTile(2, 1), t.getTile(3, 1));
        addImages(Direction.UP, t.getTile(0, 0), t.getTile(1, 0), t.getTile(2, 0));
        addImages(Direction.RIGHT, t.getTile(3, 0), t.getTile(4, 0), t.getTile(0, 1));
        addImages(Direction.DOWN, t.getTile(4, 1), t.getTile(0, 2), t.getTile(1, 2));

        setCurrentImage(Direction.DOWN, false);
    }

    private void addImages(Direction d, ImageIcon zero, ImageIcon one, ImageIcon two) {
        HashMap<Integer, ImageIcon> intIcon = new HashMap<Integer, ImageIcon>();
        intIcon.put(0, zero);
        intIcon.put(1, one);
        intIcon.put(2, two);
        images.put(d, intIcon);
    }

    public ImageIcon getImage(Direction d, boolean moving) {
        this.currentDirection = d;

        if (moving) {
            if (walkCycle.get(d) == null) walkCycle.put(d, 2);

            if (walkCycle.get(d) == 1) walkCycle.put(d, 2);
            else walkCycle.put(d, 1);
        }

        return images.get(d).get(moving ? walkCycle.get(d) : 0);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location loc) {
        if (currentLocation != null) currentLocation.setEntity(null);
        this.currentLocation = loc;
        if (loc.getEntity() != this) loc.setEntity(this);
    }

    public ImageIcon getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Direction d, boolean moving) {
        this.currentImage = getImage(d, moving);
    }
}