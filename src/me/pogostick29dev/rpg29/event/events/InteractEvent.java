package me.pogostick29dev.rpg29.event.events;

import me.pogostick29dev.rpg29.event.Event;
import me.pogostick29dev.rpg29.map.Location;

import java.awt.*;

public class InteractEvent extends Event {

    private Location location;

    public InteractEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean pointIs(Point p) {
        return getLocation().getPoint().equals(p);
    }
}