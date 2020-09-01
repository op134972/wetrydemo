package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-25 21:14
 */
public class BlockingQueueProducerConsumerFactory {

    /**
     * 队列
     */
    private BlockingQueue<Long> workingQueue = new ArrayBlockingQueue<>(1000, true);//公平，先进先出
//    private BlockingQueue<Long> workingQueue = new ArrayBlockingQueue<>(1000, false);//非公平，先进先出
//    private BlockingQueue<Long> workingQueue = new LinkedBlockingQueue<>();//无界队列

    private AtomicLong taskId = new AtomicLong(1);

    public void produce() throws InterruptedException {
        long taskId = this.taskId.getAndIncrement();
        workingQueue.put(taskId);
        System.out.println("生产：" + taskId + "，剩余：" + workingQueue.size());
    }

    public void consume() throws InterruptedException {
        Long take = workingQueue.take();
        System.out.println("消费：" + take + "，剩余：" + workingQueue.size());
    }

    public static void main(String[] args) {
        BlockingQueueProducerConsumerFactory factory = new BlockingQueueProducerConsumerFactory();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        factory.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        factory.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        producer.start();
        consumer.start();

    }


}
