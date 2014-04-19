package me.pogostick29dev.rpg29.gui;

import me.pogostick29dev.rpg29.entity.Player;
import me.pogostick29dev.rpg29.map.Direction;
import me.pogostick29dev.rpg29.map.Location;
import me.pogostick29dev.rpg29.map.MapManager;
import me.pogostick29dev.rpg29.map.Row;
import me.pogostick29dev.rpg29.tile.Layer;
import me.pogostick29dev.rpg29.tile.Tile;
import me.pogostick29dev.rpg29.util.Constants;
import me.pogostick29dev.rpg29.util.ThreadUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI extends JPanel {

    protected GUI() {
        player = new Player();

        Timer t = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });

        t.start();
    }

    protected int keyPressed = -1;

    private Player player;

    private void tick() {
        if (keyPressed != -1) {
            if (keyPressed >= KeyEvent.VK_LEFT && keyPressed <= KeyEvent.VK_DOWN) {
                handleMovement(Direction.valueOf(keyPressed));
            } else if (keyPressed == KeyEvent.VK_ENTER) {
                try {
                    final Direction d = player.getCurrentDirection();
                    final Location interactedLocation = MapManager.getInstance().getCurrentMap().getLocation(
                            player.getCurrentLocation().getPoint().x + d.getMovement().x,
                            player.getCurrentLocation().getPoint().y + d.getMovement().y
                    );

                    if (interactedLocation.getEntity() != null) {
                        // Call InteractWithEntityEvent
                    } else {
                        // Call InteractEvent
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }

            keyPressed = -1;
        }

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
                    if (loc.getEntity() != null) {
                        g.drawImage(
                                loc.getEntity().getCurrentImage().getImage(),
                                i * Constants.TILE_WIDTH,
                                j * Constants.TILE_HEIGHT,
                                this
                        );
                    }
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

    public Player getPlayer() {
        return player;
    }

    public void handleMovement(final Direction d) {
        try {
            boolean didMove = false;
            Location from = player.getCurrentLocation();
            Location to = MapManager.getInstance().getCurrentMap().getLocation(d.getPointRelativeTo(player.getCurrentLocation().getPoint()));

            player.setCurrentImage(d, true);

            if (
                    to.getPoint().getX() >= 0 &&
                            to.getPoint().getX() <= getSize().getWidth() - Constants.TILE_WIDTH &&
                            to.getPoint().getY() >= 0 &&
                            to.getPoint().getY() <= getSize().getHeight() - Constants.TILE_HEIGHT &&
                            to.getTile().getLayer() != Layer.ON &&
                            to.getEntity() == null
                    ) {
                player.setCurrentLocation(to);
                didMove = true;
            }

            ThreadUtil.runTimer(ThreadUtil.ANIMATE, new Runnable() {
                @Override
                public void run() {
                    player.setCurrentImage(d, false);
                }
            });

            if (didMove) {
                // Call event.
            }
        } catch (IndexOutOfBoundsException ingored) {
        }
    }
}