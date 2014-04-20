package me.pogostick29dev.rpg29.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadUtil {

    public static final int ANIMATE = 75;

    public static void runTimer(int duration, final Runnable run) {
        Timer t = new Timer(duration, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run.run();
            }
        });
        t.setRepeats(false);
        t.start();
    }

    public static void runThreadInBackground(final Runnable run) {
        Thread thread = new Thread(run);
        thread.start();
    }
}