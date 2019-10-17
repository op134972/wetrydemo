package metrics.test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-20 21:42
 */
public class e_TimerTest {

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);

        Timer timer = registry.timer(MetricRegistry.name(e_TimerTest.class));

        Timer.Context ctx;
        Random random = new Random();

        while (true) {
            ctx = timer.time();
            Thread.sleep(random.nextInt(100));
            ctx.stop();
        }
    }
}
