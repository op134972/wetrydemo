package metrics.test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.ExponentiallyDecayingReservoir;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-20 21:01
 */
public class d_HistogramsTest {

    public static void main(String[] args) {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();

        Histogram histogram = new Histogram(new ExponentiallyDecayingReservoir());
        registry.register(MetricRegistry.name(d_HistogramsTest.class), histogram);

        reporter.start(1, TimeUnit.SECONDS);

        while (true) {
            histogram.update(100);
        }
    }
}
