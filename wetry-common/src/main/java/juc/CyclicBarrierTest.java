package juc;

import java.util.concurrent.*;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-25 18:01
 */
public class CyclicBarrierTest {


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100000));

        int batchSize = 8;
        CyclicBarrier cb = new CyclicBarrier(batchSize);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    fun(finalI);
                }finally {
                    try {
                        cb.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            if ((i+1) % (batchSize) == 0) {
                cb.reset();
                System.out.println("");
            }

        }
        System.out.println("done");


    }


    public static void fun(int i) {
        System.out.print(i%10);
    }
}
