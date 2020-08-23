import org.apache.log4j.Logger;
import performer.Move;
import performer.MoveBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static entity.Direction.*;
import static entity.Part.*;

public class RobotHandEthernetClientMain {

    private static final Logger logger = Logger.getLogger(RobotHandEthernetClientMain.class);

    /*
     * This project was created to simplify control of robotic arm based on arduino
     * https://www.youtube.com/watch?v=AHa7NjG6lao
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
        List<Move> moveList = new ArrayList<>();
        MoveBuilder moveBuilder = new MoveBuilder();

        moveBuilder.createMoveAndAddToList(BASE, RIGHT, 210, reversed, moveList);
        moveBuilder.createMoveAndAddToList(TOP_ARM, FORWARD, 60, reversed, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, FORWARD, 70, reversed, moveList);
        moveBuilder.createMoveAndAddToList(TOP_ARM, BACKWARDS, 50, reversed, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, FORWARD, 20, reversed, moveList);
        moveBuilder.createMoveAndAddToList(HAND, GRAB, 75, reversed, moveList);
        moveBuilder.createMoveAndAddToList(HAND, GRAB, 75, reversed, moveList);
        moveBuilder.createMoveAndAddToList(HAND, GRAB, 15, reversed, moveList);

        if (reversed) {
            Collections.reverse(moveList);
        }
        for (Move move : moveList) {
            move.perform();
        }
    }

    public static void moveItemToTop(boolean r) {
        List<Move> moveList = new ArrayList<>();
        MoveBuilder moveBuilder = new MoveBuilder();

        moveBuilder.createMoveAndAddToList(TOP_ARM, BACKWARDS, 60, r, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, BACKWARDS, 70, r, moveList);
        moveBuilder.createMoveAndAddToList(TOP_ARM, FORWARD, 30, r, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, BACKWARDS, 20, r, moveList);
        moveBuilder.createMoveAndAddToList(BASE, LEFT, 210, r, moveList);

        if (r) {
            Collections.reverse(moveList);
        }
        for (Move move : moveList) {
            move.perform();
        }
    }

    public static void releaseItem(boolean r) {
        List<Move> moveList = new ArrayList<>();

        MoveBuilder moveBuilder = new MoveBuilder();

        moveBuilder.createMoveAndAddToList(BASE, LEFT, 210, r, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, FORWARD, 60, r, moveList);
        moveBuilder.createMoveAndAddToList(TOP_ARM, FORWARD, 30, r, moveList);
        //moveBuilder.createMoveAndAddToList(BOTTOM_ARM, BACKWARDS, 20, r, moveList);
        moveBuilder.createMoveAndAddToList(HAND, RELEASE, 150, r, moveList);
        moveBuilder.createMoveAndAddToList(HAND, RELEASE, 10, r, moveList);


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
