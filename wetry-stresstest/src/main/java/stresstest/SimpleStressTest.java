package stresstest;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-15 21:27
 */
public class SimpleStressTest {

    public static <T> void execute(int concurrency, int totalRequest, boolean silent, StressTestTask<Boolean> task){
        warmUp(100, task);

        System.out.println("warmUp done.\ntest begin...");

        ExecutorService executor = Executors.newCachedThreadPool(new SimpleStressTestThreadFactory("stress-test-thread-"));

        CountDownLatch requestLatch = new CountDownLatch(totalRequest);
        CountDownLatch threadLatch = new CountDownLatch(concurrency);
        AtomicLong totalCost = new AtomicLong(0);
        AtomicLong max = new AtomicLong(0);
        AtomicLong min = new AtomicLong(Integer.MAX_VALUE);
        AtomicLong succ = new AtomicLong(0);
        AtomicLong fail = new AtomicLong(0);


        OperatingSystemMXBean osmxb = ManagementFactory
                .getOperatingSystemMXBean();

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                while (syncGetAndCountDown(requestLatch) != 0) {
                    long start = System.currentTimeMillis();
                    Boolean res = task.run();
                    long end = System.currentTimeMillis();
                    if (res) {
                        succ.incrementAndGet();
                    }else{
                        fail.incrementAndGet();
                    }
                    if (!silent) {
                        System.out.println(Thread.currentThread().getName() + " execute res:" + res);
                    }
                    long cost = end - start;
                    totalCost.addAndGet(cost);
                    if (cost > max.get()) {
                        max.set(cost);
                    }
                    if (cost < min.get()) {
                        min.set(cost);
                    }
//                    System.out.println(requestLatch.getCount());
                }
                threadLatch.countDown();
            });
        }

        double systemLoadAverage = osmxb.getSystemLoadAverage();


        try {
            requestLatch.await();
            threadLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executor.shutdownNow();
        }

        System.out.println("test done...");
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("并发数：" + concurrency);
        System.out.println("总请求数：" + totalRequest);
        System.out.println("成功：" + succ.get());
        System.out.println("失败：" + fail.get());
        System.out.println("总耗时：" + totalCost.get() + "ms");
        System.out.println("平均耗时：" + totalCost.get() / totalRequest + "ms");
        System.out.println("最大耗时：" + max.get() + "ms");
        System.out.println("最小耗时：" + min.get() + "ms");
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private static synchronized long syncGetAndCountDown(CountDownLatch countDownLatch) {
        long count = countDownLatch.getCount();
        countDownLatch.countDown();
        return count;
    }

    private static void warmUp(int warmTimes, StressTestTask task) {
        for (int j = 0; j < warmTimes; j++) {
            task.run();
            System.out.println("warmUp ing....................................");
        }
    }
}
