package juc;

import java.util.concurrent.*;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-25 18:35
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100000));

        int batchSize = 8;
        CountDownLatch latch = new CountDownLatch(batchSize);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            CountDownLatch finalLatch = latch;
            executor.execute(() -> {
                fun(finalI);
                try {
                    finalLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            if ((i+1) % (batchSize) == 0) {
                latch.await();
                latch = new CountDownLatch(batchSize);
                System.out.println("");
            }

        }
        System.out.println("done");
    }

    public static void fun(int i) {
        System.out.print(i%10);
    }

}
