package performer.move;

import config.Config;
import entity.Direction;
import entity.Part;
import http.HttpGet;
import org.apache.log4j.Logger;
import tools.SoundPlayer;


public class Move {

    private static final Logger logger = Logger.getLogger(Move.class);
    private final Part part;
    private final Direction dir;
    private final int angleChange;
    private final boolean reversed;
    private final String url;

    public Move(Part part, Direction dir, int angleChange, int moveDelay, boolean reversed) {
        this.part = part;
        this.dir = dir;
        this.angleChange = angleChange;
        this.reversed = reversed;

        Direction newDirection = dir;
        if (reversed) {
            newDirection = dir.getOpposite();
        }

        url = "http://" + Config.ADDRESS + "/" + part.getName() + "X" + newDirection.getName() + "Y" + angleChange + "Z" + moveDelay + "D";
    }

    public void perform() {
        checkCaseOfIllegalAction(part, dir);

        SoundPlayer player = new SoundPlayer();
        player.playBleep();

        HttpGet.getHTML(url);
        sleep(Config.SLEEP_AFTER_MOVE_MILLIS);
        logger.info("HTTP GET " + url);
    }

    private void checkCaseOfIllegalAction(Part part, Direction dir) {
        if (part != Part.HAND && dir == Direction.GRAB || part != Part.HAND && dir == Direction.RELEASE) {
            // grab and release are only for hand
            logger.warn("grab and release are only for hand");
            return;
        }
        if (part == Part.HAND) {
            if (dir != Direction.GRAB) {
                if (dir != Direction.RELEASE) {
                    // hand can only grab or release
                    logger.warn("hand can only grab or release");
                }
            }
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
