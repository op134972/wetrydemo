package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-25 10:54
 *
 * 构建死锁
 */
public class DeadLockTest {

    static ReentrantLock lock1 = new ReentrantLock();

    static ReentrantLock lock2 = new ReentrantLock();


    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock1.lock();
                    System.out.println("t1 获取 锁1成功，尝试获取锁2");
                    lock2.lock();
                    System.out.println("t1.获取 锁2成功");
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock2.lock();
                    System.out.println("t2 获取 锁2成功，尝试获取锁1");
                    lock1.lock();
                    System.out.println("t2.获取 锁1成功");
                    lock2.unlock();
                    lock1.unlock();
                }
            }
        });

        t1.start();
        t2.start();

    }


}
