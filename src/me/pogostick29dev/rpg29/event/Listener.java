package me.pogostick29dev.rpg29.event;

public abstract class Listener<T extends Event> {

    private Class<T> eventClass;
    private boolean shouldRemove;

    public Listener(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    public Class<T> getEventClass() {
        return eventClass;
    }

    public boolean shouldRemove() {
        return shouldRemove;
    }

    public void requestRemove() {
        this.shouldRemove = true;
    }

    public abstract void onEvent(T event);
}