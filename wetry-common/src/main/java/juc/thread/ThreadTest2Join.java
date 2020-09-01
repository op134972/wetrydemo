package juc.thread;

import utils.RandomUtils;

/**
 * Created by tangwc on 2020/6/13.
 */
public class ThreadTest2Join {

    public static void main(String[] args) throws InterruptedException {
        boolean hasSauce = false;
        System.out.println("妈妈开始炒菜");
        System.out.println("妈妈放油");
        System.out.println("妈妈放盐");
        System.out.println("没有酱油了，叫小明买酱油");
        System.out.println("等小明买酱油");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("小明去买酱油");
                int buyCostTime = RandomUtils.nextInt(0, 3000);
                try {
                    Thread.sleep(buyCostTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("酱油买完了，回家，买酱油花了" + buyCostTime + " ms");
            }
        });
        thread1.start();
        //插入主线程，直到子线程执行完毕(isAlive = false)，停止阻塞
//        thread1.join();

        //插入主线程，但是只等待1000ms
        thread1.join(1000);
        if (thread1.isAlive()) {
            System.out.println("等了1000ms没回来，不用酱油了直接开饭");
        } else {
            System.out.println("小明回来了，妈妈放酱油，开饭");
        }


    }
}
