package me.pogostick29dev.rpg29.map;

import me.pogostick29dev.rpg29.audio.AudioPlayer;
import me.pogostick29dev.rpg29.gui.Frame;
import me.pogostick29dev.rpg29.util.ResourceUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MapManager {

    private MapManager() {
        maps = new ArrayList<Map>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceUtil.getInstance().getResourceAsStream("map/maps.txt")));

            while (reader.ready()) {
                maps.add(new Map(reader.readLine()));
            }

            reader.close();
        } catch (Exception ignore) {
        }

        setCurrentMap(maps.get(0));
    }

    private static MapManager instance = new MapManager();

    public static MapManager getInstance() {
        return instance;
    }

    private ArrayList<Map> maps;
    private Map currentMap;

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map map) {
        this.currentMap = map;
        Frame.getInstance().getGUI().getPlayer().setCurrentLocation(map.getSpawn());
        AudioPlayer.playMusic(map.getBackgroundMusic());
    }

    public Map getMap(String name) {
        for (Map m : maps) {
            if (m.getName().equals(name)) return m;
        }

        return null;
    }
}