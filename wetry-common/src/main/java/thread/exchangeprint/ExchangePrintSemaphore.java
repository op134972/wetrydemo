package thread.exchangeprint;

import utils.ThreadUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-06 22:43
 * <p>
 * 基于信号量
 */
public class ExchangePrintSemaphore {

    private static Semaphore semaphore = new Semaphore(1);

    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadUtils.sleepQuite(100);
                    try {
                        if (flag.get()) {
                            semaphore.acquire();
                            System.out.print("hello ");
                            flag.set(false);
                            semaphore.release();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadUtils.sleepQuite(100);
                    try {
                        if (!flag.get()) {
                            semaphore.acquire();
                            System.out.print("world ");
                            flag.set(true);
                            semaphore.release();
                        }
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
