package me.pogostick29dev.rpg29.event.events;

import me.pogostick29dev.rpg29.event.Event;
import me.pogostick29dev.rpg29.gui.Frame;
import me.pogostick29dev.rpg29.map.Location;

import java.awt.*;

public class MoveEvent extends Event {

    private Location from;

    public MoveEvent(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return Frame.getInstance().getGUI().getPlayer().getCurrentLocation();
    }

    public Location getFrom() {
        return from;
    }

    public boolean toIs(Point p) {
        return getTo().getPoint().equals(p);
    }

    public boolean fromIs(Point p) {
        return getFrom().getPoint().equals(p);
    }
}