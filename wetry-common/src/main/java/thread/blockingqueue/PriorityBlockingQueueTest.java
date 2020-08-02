package thread.blockingqueue;

import utils.RandomUtils;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-29 09:31
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        for (int i = 0; i < 100; i++) {
            int i1 = RandomUtils.nextInt(0, 10000);
            queue.put(i1);
        }

        Integer take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));
        take = queue.take();
        System.out.println("after take:" + take + ", queueArray:" + Arrays.toString(queue.toArray()));

        System.out.println("ScheduleExecutor 内部结构 ---------------------");

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
        for (int i = 0; i < 100; i++) {
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("i'm doing,i'm done");
                }
            }, RandomUtils.nextInt(100, 200), TimeUnit.SECONDS);
        }


        System.out.println("done");
    }
}
