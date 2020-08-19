
import org.apache.log4j.Logger;
import performer.Move;

import static entity.Direction.*;
import static entity.Part.*;
import static entity.Part.TOP_ARM;


public class RobotHandEthernetClientMain {

    private static final Logger logger = Logger.getLogger(RobotHandEthernetClientMain.class);

    /*
    * http://10.0.0.60/baseXleftY300Z
    * */

    public static void main(String[] args) {

        logger.info("Starting");

        grabItem(false);
        sleep(1000);
        grabItem(true);

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
//    public static void moveItemToTop(){
//
//        getHTML("http://10.0.0.60/topArmXbackwardsY60Z");
//        getHTML("http://10.0.0.60/bottomArmXbackwardsY70Z");
//        getHTML("http://10.0.0.60/topArmXforwardY30Z");
//        getHTML("http://10.0.0.60/bottomArmXbackwardsY20Z");
//        getHTML("http://10.0.0.60/baseXleftY210Z");
//    }
//

//
//    public static void releaseItem(){
//
//        getHTML("http://10.0.0.60/baseXleftY210Z");
//        //getHTML("http://10.0.0.60/topArmXforwardY60Z");
//        getHTML("http://10.0.0.60/bottomArmXforwardY60Z");
//        getHTML("http://10.0.0.60/topArmXforwardY30Z");
//        //getHTML("http://10.0.0.60/bottomArmXbackwardsY20Z");
//        getHTML("http://10.0.0.60/handXreleaseY150Z");
//        getHTML("http://10.0.0.60/handXreleaseY15Z");
//
//    }


    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
