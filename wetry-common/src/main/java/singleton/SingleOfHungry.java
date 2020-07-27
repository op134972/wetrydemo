package singleton;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 01:04
 */
public class SingleOfHungry {

    private static Object instance = new Object();

    public static Object getInstance(){
        return instance;
    }
}
