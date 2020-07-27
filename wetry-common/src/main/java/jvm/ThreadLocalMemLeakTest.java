package jvm;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 11:31
 *
 * theadLocal一般是全局的，也就是生命周期很长近似等于虚拟机的生命周期
 * threadLocal的原理实际是Thread.map<ThreadLocal,Object>，全局的
 */
public class ThreadLocalMemLeakTest {

    private static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static void set(Object obj){
        threadLocal.set(obj);
    }

    public static Object get(){
        return threadLocal.get();
    }

    public static void clear(){
        threadLocal.remove();
    }

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            while (true) {
                //构造new value
                MyObject obj = new MyObject();
                ThreadLocal<MyObject> threadLocal = new ThreadLocal<>();
                //只set，不调用 get remove
                threadLocal.set(obj);
                threadLocal.get();
//                    threadLocal.remove();
            }
        });
        t.start();
    }

    private static void test1() {
        while (true){
            Thread t = new Thread(() -> {
                ThreadLocal<Object> threadLocal = new ThreadLocal<>();
                threadLocal.set(new Object());
                threadLocal.get();
                threadLocal.remove();
            });
            t.start();
            System.out.println("thread:" + t + " done");
        }
    }

    private static void test2() {
        while (true){
            Thread t = new Thread(() -> {
                threadLocal.set(new Object());
                threadLocal.get();
//                threadLocal.remove();
            });
            t.start();
            System.out.println("thread:" + t + " done");
        }
    }

    static class MyObject{
        byte[] bytes = new byte[1024];
    }

}

