package performer;

import config.Config;
import entity.Direction;
import entity.Part;
import http.HttpGet;
import org.apache.log4j.Logger;


public class Move {

    private static final Logger logger = Logger.getLogger(Move.class);

    public static void perform(Part part, Direction dir, int angleChange, boolean reversed){
        checkCaseOfIllegalAction(part, dir);
        String url;
        Direction newDirection = dir;
        if(reversed){
            newDirection = dir.getOpposite();
        }
        url = "http://"+Config.ADDRESS+"/"+part.getName()+"X"+newDirection.getName()+"Y"+angleChange+"Z";
        HttpGet.getHTML(url);
        logger.info("HTTP GET "+url);
    }

    private static void checkCaseOfIllegalAction(Part part, Direction dir){
        if(part!=Part.HAND && dir==Direction.GRAB  ||  part!=Part.HAND && dir==Direction.RELEASE) {
            // grab and release are only for hand
            logger.warn("grab and release are only for hand");
            return;
        }
        if(part==Part.HAND){
            if(dir!=Direction.GRAB){
                if(dir!=Direction.RELEASE){
                    // hand can only grab or release
                    logger.warn("hand can only grab or release");
                    return;
                }
            }
        }
    }
}
