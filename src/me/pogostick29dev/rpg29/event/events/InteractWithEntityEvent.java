package me.pogostick29dev.rpg29.event.events;

import me.pogostick29dev.rpg29.entity.Entity;
import me.pogostick29dev.rpg29.map.Location;

public class InteractWithEntityEvent extends InteractEvent {

    private Entity entity;

    public InteractWithEntityEvent(Location location, Entity entity) {
        super(location);
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}