package performer;

import entity.Direction;
import entity.Part;

import java.util.List;

public class MoveBuilder {

    public List<Move> createMoveAndAddToList(Part part, Direction dir, int angleChange, boolean reversed, List<Move> list) {
        list.add(new Move(part, dir, angleChange, reversed));
        return list;
    }
}
