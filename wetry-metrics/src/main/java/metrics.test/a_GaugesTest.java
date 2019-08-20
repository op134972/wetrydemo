package metrics.test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-20 20:17
 */
public class a_GaugesTest {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry metricRegistry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry).build();
        reporter.start(1, TimeUnit.SECONDS);
        metricRegistry.register(MetricRegistry.name(a_GaugesTest.class, "queue", "size"), new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return list.size();
            }
        });

        while (true) {
            Thread.sleep(1000);
            list.add(0);
        }
    }

}
