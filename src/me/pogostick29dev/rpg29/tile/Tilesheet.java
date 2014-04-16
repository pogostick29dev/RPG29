package me.pogostick29dev.rpg29.tile;

import me.pogostick29dev.rpg29.util.Constants;
import me.pogostick29dev.rpg29.util.ResourceUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Tilesheet {

    private HashMap<Point, ImageIcon> tiles;
    private BufferedImage image;

    public Tilesheet(String name) {
        tiles = new HashMap<Point, ImageIcon>();

        try {
            image = ResourceUtil.getInstance().getBufferedImage(name);

            int xTiles = image.getWidth() / Constants.TILE_WIDTH;
            int yTiles = image.getHeight() / Constants.TILE_HEIGHT;

            for (int x = 0; x < xTiles; x++) {
                for (int y = 0; y < yTiles; y++) {
                    BufferedImage tileImage = new BufferedImage(Constants.TILE_WIDTH, Constants.TILE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
                    tileImage.setRGB(
                            0,
                            0,
                            Constants.TILE_WIDTH,
                            Constants.TILE_HEIGHT,
                            image.getRGB(
                                    x * Constants.TILE_WIDTH,
                                    y * Constants.TILE_HEIGHT,
                                    Constants.TILE_WIDTH,
                                    Constants.TILE_HEIGHT,
                                    null,
                                    0,
                                    Constants.TILE_WIDTH),
                            0,
                            Constants.TILE_WIDTH
                    );

                    tiles.put(new Point(x, y), new ImageIcon(tileImage));
                }
            }
        } catch (Exception ignored) {
        }
    }

    public ImageIcon getTile(int x, int y) {
        return tiles.get(new Point(x, y));
    }
}