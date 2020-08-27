import org.apache.log4j.Logger;
import performer.commonActions.GrabItemMoveBaseAndReleaseActions;

public class RobotHandEthernetClientMain {

    private static final Logger logger = Logger.getLogger(RobotHandEthernetClientMain.class);

    /*
     * This project was created to simplify control of robotic arm based on arduino
     * https://www.youtube.com/watch?v=AHa7NjG6lao
     * */

    public static void main(String[] args) {

        logger.info("Starting");

        GrabItemMoveBaseAndReleaseActions grabReleaseAction = new GrabItemMoveBaseAndReleaseActions();
        grabReleaseAction.make();

    }

}
