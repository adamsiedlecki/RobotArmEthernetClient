package entity;

import org.apache.log4j.Logger;

public enum Direction {

    FORWARD("forward"),
    BACKWARDS("backwards"),
    LEFT("left"),
    RIGHT("right"),
    GRAB("grab"),
    RELEASE("release")
    ;

    private static final Logger logger = Logger.getLogger(Direction.class);
    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Direction getOpposite() {
        if(this == FORWARD){
            return BACKWARDS;
        }else if(this == BACKWARDS){
            return FORWARD;
        }

        if(this == GRAB){
            return RELEASE;
        }else if(this == RELEASE){
            return GRAB;
        }

        if(this == RIGHT){
            return LEFT;
        }else if(this == LEFT){
            return RIGHT;
        }

        logger.error("Opposite direction error");
        return RIGHT;
    }
}
