package performer.move;

import java.util.Collections;
import java.util.List;

public class MovePerformer {

    public static void makeEach(List<Move> moveList, boolean r) {
        if (r) {
            Collections.reverse(moveList);
        }
        for (Move move : moveList) {
            move.perform();
        }
    }
}
