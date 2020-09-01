package thread.exchangeprint;

import java.util.concurrent.Semaphore;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-06 22:50
 */
public class ExchangePrintSemaphore2 {

    int i = 50;

    private static Semaphore helloSemaphore = new Semaphore(1);
    private static Semaphore worldSemaphore = new Semaphore(0);

    public static void main(String[] args) {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        helloSemaphore.acquire();
                        System.out.print("hello");
                        worldSemaphore.release(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        worldSemaphore.acquire();
                        System.out.print("world ");
                        helloSemaphore.release(1);
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
