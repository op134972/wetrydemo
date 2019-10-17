package stresstest;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Snapshot;
import com.codahale.metrics.Timer;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-15 21:27
 */
public class SimpleStressTest {

    private static Locale locale = Locale.getDefault();

    public static <T> void execute(int concurrency, int totalRequest, boolean silent, StressTestTask<Boolean> task){
        warmUp(100, task);

        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        Timer timer = new Timer();
        registry.register("StressTestTask", timer);

        System.out.println("SimpleStressTest warmUp done.\nStress test begin.");

        ExecutorService executor = Executors.newCachedThreadPool(new SimpleStressTestThreadFactory("stress-test-thread-"));

        CountDownLatch requestLatch = new CountDownLatch(totalRequest);
        CountDownLatch threadLatch = new CountDownLatch(concurrency);
        AtomicLong succ = new AtomicLong(0);
        AtomicLong fail = new AtomicLong(0);


        OperatingSystemMXBean osmxb = ManagementFactory
                .getOperatingSystemMXBean();

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                while (syncGetAndCountDown(requestLatch) != 0) {
                    Timer.Context ctx = timer.time();
                    Boolean res = task.run();
                    ctx.stop();
                    if (res) {
                        succ.incrementAndGet();
                    }else{
                        fail.incrementAndGet();
                    }
                    if (!silent) {
                        System.out.println(Thread.currentThread().getName() + ":single task execute res:" + res);
                    }
                }
                threadLatch.countDown();
            });
        }

        try {
            requestLatch.await();
            threadLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executor.shutdownNow();
        }


        System.out.println("SimpleStressTest stress test done.");

        synchronized (SimpleStressTest.class) {
            System.out.println("=================================================================");
            Snapshot snapshot = timer.getSnapshot();
            System.out.println(String.format(locale, "             count = %d", timer.getCount()));
            System.out.println(String.format(locale, "           success = %d", succ.get()));
            System.out.println(String.format(locale, "              fail = %d", fail.get()));
            System.out.println(String.format(locale, "         mean rate = %2.2f calls/sec", timer.getMeanRate()));
            System.out.println(String.format(locale, "     1-minute rate = %2.2f calls/sec", timer.getOneMinuteRate()));
            System.out.println(String.format(locale, "     5-minute rate = %2.2f calls/sec", timer.getFiveMinuteRate()));
            System.out.println(String.format(locale, "    15-minute rate = %2.2f calls/sec", timer.getFifteenMinuteRate()));
            System.out.println(String.format(locale, "               min = %2.2f ms", convertDuration(snapshot.getMin())));
            System.out.println(String.format(locale, "               max = %2.2f ms", convertDuration(snapshot.getMax())));
            System.out.println(String.format(locale, "              mean = %2.2f ms", convertDuration(snapshot.getMean())));
            System.out.println(String.format(locale, "            stddev = %2.2f ms", convertDuration(snapshot.getStdDev())));
            System.out.println(String.format(locale, "            median = %2.2f ms", convertDuration(snapshot.getMedian())));
            System.out.println(String.format(locale, "              75%% <= %2.2f ms", convertDuration(snapshot.get75thPercentile())));
            System.out.println(String.format(locale, "              95%% <= %2.2f ms", convertDuration(snapshot.get95thPercentile())));
            System.out.println(String.format(locale, "              98%% <= %2.2f ms", convertDuration(snapshot.get98thPercentile())));
            System.out.println(String.format(locale, "              99%% <= %2.2f ms", convertDuration(snapshot.get99thPercentile())));
            System.out.println(String.format(locale, "            99.9%% <= %2.2f ms", convertDuration(snapshot.get999thPercentile())));
            System.out.println("=================================================================");
        }
    }

    private static synchronized long syncGetAndCountDown(CountDownLatch countDownLatch) {
        long count = countDownLatch.getCount();
        countDownLatch.countDown();
        return count;
    }

    private static void warmUp(int warmTimes, StressTestTask task) {
        for (int j = 0; j < warmTimes; j++) {
            task.run();
            System.out.println("SimpleStressTest warmUp executing...");
        }
    }

    private static double convertDuration(double duration) {
        return duration / 1000000;
    }
}
