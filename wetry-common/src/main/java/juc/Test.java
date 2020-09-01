package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-11 17:26
 */
public class Test {

    private static UnsafeInteger unsafe = new UnsafeInteger();
    private static MyAtomicInteger my = new MyAtomicInteger();
    private static AtomicInteger atomic = new AtomicInteger();

    public static void main(String[] args) throws Exception {


        Thread a = new Thread(() -> {
            for (int j = 0; j < 1000000; j++) {
                try {
                    unsafe.incrAndGet();
                    my.incrAndGet();
                    atomic.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(() -> {
            for (int j = 0; j < 1000000; j++) {
                try {
                    unsafe.incrAndGet();
                    my.incrAndGet();
                    atomic.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();
        b.join();
        a.join();
        System.out.println(unsafe.get());
        System.out.println(my.get());
        System.out.println(atomic.get());
    }
}
