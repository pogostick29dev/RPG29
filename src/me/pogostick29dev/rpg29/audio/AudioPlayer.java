package me.pogostick29dev.rpg29.audio;

import javazoom.jl.player.Player;
import me.pogostick29dev.rpg29.util.ResourceUtil;
import me.pogostick29dev.rpg29.util.ThreadUtil;

public class AudioPlayer {

    public static void playMusic(final Music music) {
        ThreadUtil.runThreadInBackground(new Runnable() {
            @Override
            public void run() {
                try {
                    /*
                    JLayer Audio Player
                     */
                    Player player = new Player(ResourceUtil.getInstance().getResourceAsStream(music.getPath()));
                    player.play();
                    player.close();

                    /*
                    JavaFX Audio Player
                     */
//                    Media media = new Media(ResourceUtil.getInstance().getResource(music.getPath()).toExternalForm());
//                    MediaPlayer player = new MediaPlayer(media);
//                    player.setCycleCount(Integer.MAX_VALUE);
//                    player.setVolume(.5);
//                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}