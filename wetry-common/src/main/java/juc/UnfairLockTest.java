package juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: tangwenchuan
 * @Date: 2019-09-05 21:30
 */
public class UnfairLockTest {


    /**
     * 非公平锁的线程
     */
    public static void main(String[] args) {
        //非公平
        ReentrantLock lock = new ReentrantLock(false);


    }
}
