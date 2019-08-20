package metrics.test;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-20 20:30
 */
public class b_CounterTest {

    private static Counter counter;

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        counter = registry.counter(MetricRegistry.name(b_CounterTest.class, "counter"));
        reporter.start(1, TimeUnit.SECONDS);

        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0) {
                counterDec();
            }else{
                counterInc();
            }
            Thread.sleep(1000);
        }
    }

    private static void counterInc(){
        counter.inc();
    }

    private static void counterDec(){
        counter.dec();
    }
}
