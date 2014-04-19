package me.pogostick29dev.rpg29.gui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {

    private GUI gui;

    private Frame() {
        super("RPG29");

        gui = new GUI();
        add(gui);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gui.keyPressed = e.getKeyCode();
            }
        });

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

    public GUI getGUI() {
        return gui;
    }
}