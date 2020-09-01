package juc.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by tangwc on 2020/6/13.
 */
public class ThreadTest4Park {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取permit，为0（默认），则阻塞
                System.out.println("park, blocking ... ");
                LockSupport.park();
                //二次park 需要二次unpark
//                LockSupport.park();
                System.out.println("stop block ");
            }
        });

        t.start();

        Thread.sleep(1000);

        //permit+1，此时t线程停止阻塞
        System.out.println("unpark");
        LockSupport.unpark(t);
        t.join();

    }
}
