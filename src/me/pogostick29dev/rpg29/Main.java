package me.pogostick29dev.rpg29;

import me.pogostick29dev.rpg29.gui.Frame;
import me.pogostick29dev.rpg29.util.ResourceUtil;

public class Main {

    private Main() {
        ResourceUtil.getInstance().setup(getClass());

        Frame.getInstance();
    }

    public static void main(String[] args) {
        new Main();
    }
}