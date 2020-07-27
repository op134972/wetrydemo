package thread;

import utils.RandomUtils;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-26 22:55
 */
public class CompletionServiceTest {

    private static ExecutorCompletionService<MyTask> completionService = new ExecutorCompletionService<>(Executors.newCachedThreadPool());

    public static void main(String[] args) {

        AtomicLong id = new AtomicLong(1);

        //分发线程
        Thread dispatcherThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                doSth();
                completionService.submit(() -> {
                    return new MyTask(id.getAndIncrement());
                });
            }
        });

        dispatcherThread.start();

        Thread resultPrinter = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
//                        //poll不会阻塞，为空返回null
//                        completionService.poll();
                        Future<MyTask> poll = completionService.take();
                        System.out.println(poll.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        resultPrinter.start();
    }

    private static void doSth() {
        try {
            Thread.sleep(RandomUtils.nextInt(0, 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class MyTask {
        long taskId;

        @Override
        public String toString() {
            return "MyTask{" +
                    "taskId=" + taskId +
                    '}';
        }

        public MyTask(long taskId) {
            this.taskId = taskId;
        }
    }
}
