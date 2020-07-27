package singleton;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 00:24
 *
 * double check lock 双重检查加锁
 * 1. volatile
 * 2. double check
 * 3. 类锁
 */
public class SingleOfDoubleCheck {

    //volatile是必要的的，否则可能拿到不完整的实例
    private volatile static SingleOfDoubleCheck instance;

    public SingleOfDoubleCheck getInstance(){
        if (instance == null) {
            synchronized (SingleOfDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingleOfDoubleCheck();
                }
            }
        }
        return instance;
    }
}
