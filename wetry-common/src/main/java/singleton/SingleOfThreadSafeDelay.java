package singleton;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 01:04
 */
public class SingleOfThreadSafeDelay {

    private static Object instance;

    public synchronized static Object getInstance(){
        if (instance == null) {
            instance = new Object();
        }
        return instance;
    }
}
