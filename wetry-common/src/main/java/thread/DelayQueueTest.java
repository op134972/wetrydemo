package thread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-26 22:28
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        DelayQueue<Delay> delayQueue = new DelayQueue<>();

//        delayQueue.
    }

    class Delay implements Delayed {

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

}
