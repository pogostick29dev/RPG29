package me.pogostick29dev.rpg29.map;

import java.awt.*;
import java.awt.event.KeyEvent;

public enum Direction {

    LEFT, UP, RIGHT, DOWN;

    public Point getMovement() {
        switch (values()[ordinal()]) {
            case LEFT: return new Point(0, -1);
            case UP: return new Point(-1, 0);
            case RIGHT: return new Point(0, 1);
            case DOWN: return new Point(1, 0);
            default: return null;
        }
    }

    public Point getPointRelativeTo(Point p) {
        switch (values()[ordinal()]) {
            case LEFT: return new Point(p.x, p.y - 1);
            case UP: return new Point(p.x - 1, p.y);
            case RIGHT: return new Point(p.x, p.y + 1);
            case DOWN: return new Point(p.x + 1, p.y);
            default: return null;
        }
    }

    public static Direction valueOf(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT) return Direction.LEFT;
        else if (keyCode == KeyEvent.VK_UP) return Direction.UP;
        else if (keyCode == KeyEvent.VK_RIGHT) return Direction.RIGHT;
        else if (keyCode == KeyEvent.VK_DOWN) return Direction.DOWN;
        else return null;
    }
}