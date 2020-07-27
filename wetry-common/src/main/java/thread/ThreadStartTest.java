package thread;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 00:39
 */
public class ThreadStartTest {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前运行线程：" + Thread.currentThread());
            }
        });

        System.out.println("调用run");
        t.run();

        System.out.println("调用start");
        t.start();

    }
}
