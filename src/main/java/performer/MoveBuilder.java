package performer;

import entity.Direction;
import entity.Part;

import java.util.List;

public class MoveBuilder {

    public void createMoveAndAddToList(Part part, Direction dir, int angleChange, boolean reversed, List<Move> list) {
        int moveDelay = 0;

        if (part == Part.BOTTOM_ARM) {
            moveDelay = 20;
        } else if (part == Part.TOP_ARM) {
            moveDelay = 40;
        }

        list.add(new Move(part, dir, angleChange, moveDelay, reversed));
    }
}
