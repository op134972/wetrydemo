package thread.exchangeprint;

import utils.ThreadUtils;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-06 20:11
 *
 * 基于线程wait notify
 */
public class ExchangePrintWaitNotify {


    private static final Object mutex = new Object();

    private static int flag = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadUtils.sleepQuite(100);
                while (true) {
                    synchronized (mutex) {
                        if (flag == 0) {
                            System.out.print("hello");
                            flag = 1;
                            mutex.notifyAll();
                        } else {
                            try {
                                mutex.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadUtils.sleepQuite(100);
                    synchronized (mutex) {

                        if (flag == 1) {
                            System.out.print("world ");
                            flag = 0;
                            mutex.notifyAll();
                        } else {
                            try {
                                mutex.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
        t1.start();
        t2.start();

    }

    private void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}
