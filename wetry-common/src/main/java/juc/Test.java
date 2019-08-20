package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-11 17:26
 */
public class Test {


    public static void main2(String[] args) {

        MyAtomicInteger m = new MyAtomicInteger();
        UnsafeInteger u = new UnsafeInteger();
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                try {
//                    System.out.println(finalI + 1 + ":" + m.incrAndGet());
                    System.out.println(finalI + 1 + "|" + u.incrAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.run();
        }
        System.out.println(m.get());
        System.out.println(u.get());
    }

    private static UnsafeInteger u = new UnsafeInteger();
    private static MyAtomicInteger m = new MyAtomicInteger();
    private static AtomicInteger aa = new AtomicInteger();

    public static void main(String[] args) throws Exception {


        Thread a = new Thread(() -> {
            for (int j = 0; j < 1000000; j++) {
                try {
                    u.incrAndGet();
                    m.incrAndGet();
                    aa.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        Thread b = new Thread(() -> {
            for (int j = 0; j < 1000000; j++) {
                try {
                    u.incrAndGet();
                    m.incrAndGet();
                    aa.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        b.start();
        b.join();
        a.join();
        System.out.println(u.get());
        System.out.println(m.get());
        System.out.println(aa.get());
    }
}
