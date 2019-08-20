package metrics.test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-20 21:01
 */
public class d_HistogramsTest {

    public static void main(String[] args) {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        registry.histogram(MetricRegistry.name(d_HistogramsTest.class,"histograms"),new Histogram(new Re))
    }
}
