package me.pogostick29dev.rpg29.map;

import java.util.ArrayList;

public class Row {

    private ArrayList<Location> locations;

    public Row(String raw, int row) {
        locations = new ArrayList<Location>();

        String[] split = raw.split(" ");
        for (int i = 0; i < split.length; i++) {
            locations.add(new Location(split[i], row, i));
        }
    }

    public Location getLocationAt(int column) {
        return locations.get(column);
    }

    public Location[] getLocations() {
        return locations.toArray(new Location[locations.size()]);
    }
}