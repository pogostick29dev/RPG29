package me.pogostick29dev.rpg29.game;

import me.pogostick29dev.rpg29.event.EventDispatcher;
import me.pogostick29dev.rpg29.event.Listener;
import me.pogostick29dev.rpg29.event.events.MoveEvent;

import java.awt.*;

public class SampleListener {

    public SampleListener() {
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