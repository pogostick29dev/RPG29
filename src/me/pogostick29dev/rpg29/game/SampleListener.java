package me.pogostick29dev.rpg29.game;

import me.pogostick29dev.rpg29.entity.Player;
import me.pogostick29dev.rpg29.event.EventDispatcher;
import me.pogostick29dev.rpg29.event.Listener;
import me.pogostick29dev.rpg29.event.events.InteractWithEntityEvent;
import me.pogostick29dev.rpg29.event.events.MoveEvent;
import me.pogostick29dev.rpg29.map.MapManager;

import java.awt.*;

public class SampleListener {

    private int i;

    public SampleListener() {
        final Player npc = new Player();
        npc.setCurrentLocation(MapManager.getInstance().getCurrentMap().getLocation(1, 1));

        EventDispatcher.getInstance().registerListener(new Listener<InteractWithEntityEvent>(InteractWithEntityEvent.class) {
            @Override
            public void onEvent(InteractWithEntityEvent e) {
                if (e.getEntity().equals(npc)) {
                    if (i < 5) {
                        System.out.println("Hello there");
                        i++;
                    } else {
                        requestRemove();
                    }
                }
            }
        });

        EventDispatcher.getInstance().registerListener(new Listener<MoveEvent>(MoveEvent.class) {
            @Override
            public void onEvent(MoveEvent e) {
                if (e.toIs(new Point(0, 0))) {
                    System.out.println("0, 0");
                    requestRemove();
                }
            }
        });
    }
}