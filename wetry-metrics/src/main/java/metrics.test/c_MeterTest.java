package metrics.test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-20 20:39
 *
 * Meter统计tps，mark()方法
 */
public class c_MeterTest {

    private static Meter meter;

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        meter = registry.meter(MetricRegistry.name(c_MeterTest.class));
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);


        while (true) {
            Thread.sleep(1);
            fun();
        }

    }

    private static void fun(){
//        System.out.println("fun done...");
        meter.mark();
    }
}
