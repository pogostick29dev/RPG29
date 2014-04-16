package me.pogostick29dev.rpg29.map;

import java.util.ArrayList;

public class Map {

    private ArrayList<Row> rows;
    private String name;
    private MapType type;
    private Location spawn;

    public Map(String name) {
        // Read in map from text file.
    }

    public String getName() {
        return name;
    }

    public MapType getType() {
        return type;
    }

    public Location getSpawn() {
        return spawn;
    }
}