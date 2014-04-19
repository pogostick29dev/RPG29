package me.pogostick29dev.rpg29.event;

import java.util.ArrayList;

public class EventDispatcher {

    private EventDispatcher() {
        listeners = new ArrayList<Listener>();
    }

    private static EventDispatcher instance = new EventDispatcher();

    public static EventDispatcher getInstance() {
        return instance;
    }

    private ArrayList<Listener> listeners;

    public void registerListener(Listener l) {
        listeners.add(l);
    }

    public void callEvent(Event e) {
        ArrayList<Listener> remove = new ArrayList<Listener>();

        for (Listener l : listeners) {
            if (l.getEventClass().equals(e.getClass())) {
                l.onEvent(e);
                if (l.shouldRemove()) remove.add(l);
            }
        }

        listeners.removeAll(remove);
    }
}