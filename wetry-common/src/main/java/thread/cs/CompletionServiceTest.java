package thread.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zjhua
 * @description
 * @date 2020/1/28 21:07
 */
public class CompletionServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testFuture();
        testCompletionService();
    }

    //结果的输出和线程的放入顺序 有关(如果前面的没完成，就算后面的哪个完成了也得等到你的牌号才能输出！)，so阻塞耗时
    public static void testFuture() throws InterruptedException, ExecutionException {
        long beg = System.currentTimeMillis();
        System.out.println("testFuture()开始执行：" + beg);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> result = new ArrayList<Future<String>>();
        for (int i = 5; i > 0; i--) {
            Future<String> submit = executor.submit(new Task(i));
            result.add(submit);
        }
        executor.shutdown();
        for (int i = 0; i < 5; i++) {//一个一个等待返回结果
            Thread.sleep(500);
            System.out.println("线程" + i + "执行完成:" + result.get(i).get());
        }
        System.out.println("testFuture()执行完成:" + System.currentTimeMillis() + "," + (System.currentTimeMillis()-beg));
    }

    //结果的输出和线程的放入顺序 无关(谁完成了谁就先输出！主线程总是能够拿到最先完成的任务的返回值，而不管它们加入线程池的顺序)，so很大大缩短等待时间
    private static void testCompletionService() throws InterruptedException, ExecutionException {
        long beg = System.currentTimeMillis();
        System.out.println("testFuture()开始执行：" + beg);
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        for (int i = 5; i > 0; i--) {
            completionService.submit(new Task(i));
        }
        executor.shutdown();
        for (int i = 0; i < 5; i++) {
            // 检索并移除表示下一个已完成任务的 Future，如果目前不存在这样的任务，则等待。
            Future<String> future = completionService.take(); //这一行没有完成的任务就阻塞
            Thread.sleep(500);
            System.out.println("线程" + i + "执行完成:" + future.get());   // 这一行在这里不会阻塞，引入放入队列中的都是已经完成的任务
        }
        System.out.println("testFuture()执行完成:" + System.currentTimeMillis() + "," + (System.currentTimeMillis() - beg));
    }

    private static class Task implements Callable<String> {

        private volatile int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(i*500);
            return "任务 : " + i;
        }

    }


}