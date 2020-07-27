package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-26 18:03
 */
public class BarrierTest {

    private static CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
        @Override
        public void run() {
            System.out.println("到达临界点。当前执行线程是：" + Thread.currentThread());
        }
    });


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程相互等待，当前线程：" + Thread.currentThread());
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }

}
