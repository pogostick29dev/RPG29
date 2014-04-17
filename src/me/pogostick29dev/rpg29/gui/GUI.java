package me.pogostick29dev.rpg29.gui;

import me.pogostick29dev.rpg29.map.Location;
import me.pogostick29dev.rpg29.map.MapManager;
import me.pogostick29dev.rpg29.map.Row;
import me.pogostick29dev.rpg29.tile.Layer;
import me.pogostick29dev.rpg29.tile.Tile;
import me.pogostick29dev.rpg29.util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel {

    protected GUI() {
        Timer t = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });

        t.start();
    }

    private void tick() {
        // Check input.

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        drawTiles(g, Layer.BACKGROUND);
        drawTiles(g, Layer.BELOW);
        drawTiles(g, Layer.ON);
        drawTiles(g, Layer.ENTITY);
        drawTiles(g, Layer.ABOVE);
    }

    private void drawTiles(Graphics g, Layer l) {
        for (int j = 0; j < Constants.NUM_ROWS; j++) {
            Row row = MapManager.getInstance().getCurrentMap().getRow(j);
            for (int i = 0; i < Constants.TILES_PER_ROW; i++) {
                Location loc = row.getLocationAt(i);

                if (l == Layer.BACKGROUND) {
                    g.drawImage(
                            MapManager.getInstance().getCurrentMap().getType().getTile().getImage().getImage(),
                            i * Constants.TILE_WIDTH,
                            j * Constants.TILE_HEIGHT,
                            this
                    );
                } if (l == Layer.ENTITY) {
                    // Draw entities.
                } else {
                    if (loc.getTile() != Tile.EMPTY && loc.getTile().getLayer() == l) {
                        g.drawImage(
                                loc.getTile().getImage().getImage(),
                                i * Constants.TILE_WIDTH,
                                j * Constants.TILE_HEIGHT,
                                this
                        );
                    }
                }
            }
        }
    }
}