package thread.exchangeprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-06 22:59
 * 基于锁的实现
 */
public class ExchangePrintLock {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition helloCondition = lock.newCondition();
    private static Condition worldCondition = lock.newCondition();

    private static volatile int flag = 0;//不加volatile也可以，lock的获取，保证了happens-before偏序


    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    try {
                        lock.lock();
                        if (flag == 0) {
                            System.out.print("hello");
                            flag = 1;
                        }
                        worldCondition.signal();
                        helloCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    try {
                        lock.lock();
                        if (flag == 1) {
                            System.out.print("world ");
                            flag = 0;
                        }
                        helloCondition.signal();
                        worldCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

}
