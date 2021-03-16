package juc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tangwc on 2020/6/13.
 */
public class ThreadTest3Interrupt {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //1. sleep 中途 interrupt会抛出异常
//                    Thread.sleep(5000);

                    //2. wait 中途 interrupt会抛出异常
//                    synchronized (this) {
                    //wait 最好在同步代码快中调用，否则可能会引发死锁
//                        wait();
//                    }

                    //3. join 中途 interrupt会抛出异常
//                    Thread.currentThread().join();

                    //4. synchronized interrupt不会响应，interrupted为true
//                    synchronized (this) {
//                        while (true) {
//                          //保证线程非消亡
//                        }
//                    }

                    //5. park  interrupt不会响应，interrupted为true
//                    LockSupport.park();
//                    while (true) {
//                        //保持线程非消亡
//                    }

                    //6. lock interrupt不会相应，flag置位true
                    Lock lock = new ReentrantLock();
                    lock.lock();
                    while (true) {

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        Thread.sleep(1000);

        t.interrupt();
//        LockSupport.unpark(t);

        //线程消亡了，这个返回的也是false
        System.out.println(t.isInterrupted());

    }
}
