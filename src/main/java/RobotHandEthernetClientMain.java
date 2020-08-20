import org.apache.log4j.Logger;
import performer.Move;

import static entity.Direction.*;
import static entity.Part.*;

public class RobotHandEthernetClientMain {

    private static final Logger logger = Logger.getLogger(RobotHandEthernetClientMain.class);

    /*
     * This project was created to simplify control of robotic arm based on arduino
     * */

    public static void main(String[] args) {

        logger.info("Starting");

        grabItem(false);
        moveItemToTop(false);
        releaseItem(false);
//
//        releaseItem(true);
//        moveItemToTop(true);
//        grabItem(true);

    }

    public static void grabItem(boolean reversed){
        Move.perform(BASE, RIGHT, 210, reversed);

        Move.perform(TOP_ARM, FORWARD, 60, reversed);
        sleep(200);
        Move.perform(BOTTOM_ARM, FORWARD, 70, reversed);
        Move.perform(TOP_ARM, BACKWARDS, 50, reversed);
        sleep(500);
        Move.perform(BOTTOM_ARM, FORWARD, 20, reversed);
        sleep(500);
        Move.perform(HAND, GRAB, 75, reversed);

        sleep(1000);
        Move.perform(HAND, GRAB, 75, reversed);
        Move.perform(HAND, GRAB, 15, reversed);
    }

    public static void moveItemToTop(boolean r) {
        Move.perform(TOP_ARM, BACKWARDS, 60, r);
        Move.perform(BOTTOM_ARM, BACKWARDS, 70, r);
        Move.perform(TOP_ARM, FORWARD, 30, r);
        Move.perform(BOTTOM_ARM, BACKWARDS, 20, r);
        Move.perform(BASE, LEFT, 210, r);
    }

    public static void releaseItem(boolean r) {

        Move.perform(BASE, LEFT, 210, r);
        //Move.perform(TOP_ARM, FORWARD, 60, false);
        Move.perform(BOTTOM_ARM, FORWARD, 60, false);
        Move.perform(TOP_ARM, FORWARD, 30, false);
        Move.perform(BOTTOM_ARM, BACKWARDS, 20, false);
        Move.perform(HAND, RELEASE, 150, false);
        Move.perform(HAND, RELEASE, 10, false);

    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
