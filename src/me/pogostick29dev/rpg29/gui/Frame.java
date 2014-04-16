package me.pogostick29dev.rpg29.gui;

import javax.swing.*;

public class Frame extends JFrame {

    private Frame() {
        super("RPG29");

        gui = new GUI();
        add(gui);

        setSize(640, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static final Frame instance = new Frame();

    public static Frame getInstance() {
        return instance;
    }

    private GUI gui;

    public GUI getGUI() {
        return gui;
    }
}