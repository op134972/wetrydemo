package utils;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-06 22:39
 */
public class ThreadUtils {


    public static void sleepQuite(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
