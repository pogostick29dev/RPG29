package me.pogostick29dev.rpg29.map;

import me.pogostick29dev.rpg29.audio.Music;
import me.pogostick29dev.rpg29.util.ResourceUtil;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Map {

    private ArrayList<Row> rows;
    private String name;
    private MapType type;
    private Music backgroundMusic;
    private Location spawn;

    public Map(String name) {
        rows = new ArrayList<Row>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceUtil.getInstance().getResourceAsStream("map/" + name)));

            this.name = reader.readLine();
            this.type = MapType.valueOf(reader.readLine());
            this.backgroundMusic = Music.valueOf(reader.readLine());

            String spawnLine = reader.readLine();
            int spawnRow = Integer.valueOf(spawnLine.split(" ")[0]);
            int spawnColumn = Integer.valueOf(spawnLine.split(" ")[1]);

            int i = 0;

            while (reader.ready()) {
                rows.add(new Row(reader.readLine(), i++));
            }

            this.spawn = getLocation(spawnRow, spawnColumn);

            reader.close();
        } catch (Exception ignore) {
        }
    }

    public String getName() {
        return name;
    }

    public MapType getType() {
        return type;
    }

    public Row getRow(int row) {
        return rows.get(row);
    }

    public Row[] getRows() {
        return rows.toArray(new Row[rows.size()]);
    }

    public Location getLocation(int row, int column) {
        return rows.get(row).getLocationAt(column);
    }

    public Location getLocation(Point point) {
        return getLocation(point.x, point.y);
    }

    public Music getBackgroundMusic() {
        return backgroundMusic;
    }

    public Location getSpawn() {
        return spawn;
    }
}