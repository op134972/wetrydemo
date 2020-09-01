package synchronize;

/**
 * Created by tangwc on 2020/7/19.
 *
 * 内存屏障可见性
 */
public class AvailableTest {

    private static int num = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (AvailableTest.class) {
                    /**
                     * 修改变量值，并sleep，t2能看到修改后的值吗？
                     */
                    System.out.println("t1修改前,num:" + num);
                    System.out.println("t1sleep 10s");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num = 2;
                    System.out.println("t1修改为，num：" + num);
                    System.out.println("t1sleep 10s");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1退出同步代码块");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("t2一直读num：" + num);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
