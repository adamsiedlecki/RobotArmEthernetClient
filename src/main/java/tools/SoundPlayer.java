package tools;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoundPlayer {

    private static final Logger logger = Logger.getLogger(SoundPlayer.class);

    public void playBleep() {
        File file = new File("src/main/resources/bleep.mp3");
        PlayerThread playerThread = new PlayerThread(file);
        playerThread.start();


    }

    private static class PlayerThread extends Thread {
        private final File file;

        public PlayerThread(File file) {
            this.file = file;

        }

        @Override
        public void run() {
            FileInputStream in;
            try {
                in = new FileInputStream(file);
                AdvancedPlayer player = new AdvancedPlayer(in);
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                } finally {
                    in.close();
                    player.close();
                }
            } catch (JavaLayerException | IOException e) {
                logger.error(e);
            }
        }
    }
}
