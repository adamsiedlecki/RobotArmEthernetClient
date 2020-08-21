import org.apache.log4j.Logger;
import performer.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        releaseItem(true);
        //moveItemToTop(true);
        //grabItem(true);

    }

    public static void grabItem(boolean reversed) {
        Move m1 = new Move(BASE, RIGHT, 210, reversed);
        Move m2 = new Move(TOP_ARM, FORWARD, 60, reversed);
        Move m3 = new Move(BOTTOM_ARM, FORWARD, 70, reversed);
        Move m4 = new Move(TOP_ARM, BACKWARDS, 50, reversed);
        Move m5 = new Move(BOTTOM_ARM, FORWARD, 20, reversed);
        Move m6 = new Move(HAND, GRAB, 75, reversed);
        Move m7 = new Move(HAND, GRAB, 75, reversed);
        Move m8 = new Move(HAND, GRAB, 15, reversed);

        List<Move> moveList = new ArrayList<>(List.of(m1, m2, m3, m4, m5, m6, m7, m8));
        if (reversed) {
            Collections.reverse(moveList);
        }
        for (Move move : moveList) {
            move.perform();
        }
    }

    public static void moveItemToTop(boolean r) {
        Move m1 = new Move(TOP_ARM, BACKWARDS, 60, r);
        Move m2 = new Move(BOTTOM_ARM, BACKWARDS, 70, r);
        Move m3 = new Move(TOP_ARM, FORWARD, 30, r);
        Move m4 = new Move(BOTTOM_ARM, BACKWARDS, 20, r);
        Move m5 = new Move(BASE, LEFT, 210, r);

        List<Move> moveList = new ArrayList<>(List.of(m1, m2, m3, m4, m5));
        if (r) {
            Collections.reverse(moveList);
        }
        for (Move move : moveList) {
            move.perform();
        }
    }

    public static void releaseItem(boolean r) {

        Move m1 = new Move(BASE, LEFT, 210, r);
        Move m2 = new Move(BOTTOM_ARM, FORWARD, 60, r);
        Move m3 = new Move(TOP_ARM, FORWARD, 30, r);
        Move m4 = new Move(BOTTOM_ARM, BACKWARDS, 20, r);
        Move m5 = new Move(HAND, RELEASE, 150, r);
        Move m6 = new Move(HAND, RELEASE, 10, r);

        List<Move> moveList = new ArrayList<>(List.of(m1, m2, m3, m4, m5, m6));
        if (r) {
            Collections.reverse(moveList);
        }
        for (Move move : moveList) {
            move.perform();
        }
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
