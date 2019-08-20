package concurrent;

import java.util.concurrent.Semaphore;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-30 22:02
 *
 *
 * semaphore可以用作互斥锁，最小粒度的控制串行。
 */
public class SemaphoreTest {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Semaphore sm = new Semaphore(1);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                try {
                    sm.acquire();
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    sm.release();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                try {
                    sm.acquire();
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    sm.release();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
