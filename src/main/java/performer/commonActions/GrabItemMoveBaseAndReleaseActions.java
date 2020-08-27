package performer.commonActions;

import performer.move.Move;
import performer.move.MoveBuilder;
import performer.move.MovePerformer;

import java.util.ArrayList;
import java.util.List;

import static entity.Direction.*;
import static entity.Part.*;

public class GrabItemMoveBaseAndReleaseActions {

    public void make() {
        prepareToGrabItem(false);
        grabItemByHand(false);
        moveItemToTop(false);
        // prepareToGrabItem(true);
        prepareToReleaseItem(false);
        grabItemByHand(true);
        prepareToReleaseItem(true);
    }

    private void prepareToGrabItem(boolean reversed) {
        List<Move> moveList = new ArrayList<>();
        MoveBuilder moveBuilder = new MoveBuilder();

        moveBuilder.createMoveAndAddToList(BASE, RIGHT, 210, reversed, moveList);
        moveBuilder.createMoveAndAddToList(TOP_ARM, FORWARD, 60, reversed, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, FORWARD, 70, reversed, moveList);
        moveBuilder.createMoveAndAddToList(TOP_ARM, BACKWARDS, 50, reversed, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, FORWARD, 20, reversed, moveList);

        MovePerformer.makeEach(moveList, reversed);
    }

    private void grabItemByHand(boolean r) {
        List<Move> moveList = new ArrayList<>();
        MoveBuilder moveBuilder = new MoveBuilder();

        moveBuilder.createMoveAndAddToList(HAND, GRAB, 75, r, moveList);
        moveBuilder.createMoveAndAddToList(HAND, GRAB, 75, r, moveList);
        moveBuilder.createMoveAndAddToList(HAND, GRAB, 15, r, moveList);

        MovePerformer.makeEach(moveList, r);
    }

    private void moveItemToTop(boolean r) {
        List<Move> moveList = new ArrayList<>();
        MoveBuilder moveBuilder = new MoveBuilder();

        moveBuilder.createMoveAndAddToList(TOP_ARM, BACKWARDS, 60, r, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, BACKWARDS, 70, r, moveList);
        moveBuilder.createMoveAndAddToList(TOP_ARM, FORWARD, 50, r, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, BACKWARDS, 20, r, moveList);
        moveBuilder.createMoveAndAddToList(BASE, LEFT, 210, r, moveList);

        MovePerformer.makeEach(moveList, r);
    }

    private void prepareToReleaseItem(boolean r) {
        List<Move> moveList = new ArrayList<>();

        MoveBuilder moveBuilder = new MoveBuilder();

        moveBuilder.createMoveAndAddToList(BASE, LEFT, 210, r, moveList);
        moveBuilder.createMoveAndAddToList(BOTTOM_ARM, FORWARD, 60, r, moveList);
        moveBuilder.createMoveAndAddToList(TOP_ARM, FORWARD, 30, r, moveList);
        //moveBuilder.createMoveAndAddToList(BOTTOM_ARM, BACKWARDS, 20, r, moveList);
//        moveBuilder.createMoveAndAddToList(HAND, RELEASE, 150, r, moveList);
//        moveBuilder.createMoveAndAddToList(HAND, RELEASE, 10, r, moveList);

        MovePerformer.makeEach(moveList, r);
    }
}
