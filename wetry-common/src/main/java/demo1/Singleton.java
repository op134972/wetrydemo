package demo1;

/**
 * double check lock
 */
public class Singleton {

    /**
     1.为对象分配内存
     2.初始化实例对象
     3.把引用instance指向分配的内存空间

     重排序 132 会导致出错   需volatile
     */
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
