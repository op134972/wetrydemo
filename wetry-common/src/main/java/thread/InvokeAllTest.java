package thread;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-27 00:11
 */
public class InvokeAllTest {

    static class MyTask2 implements Callable<Integer> {

        private int costTime = RandomUtils.nextInt(0, 1000);

        @Override
        public Integer call() throws Exception {
            //耗时随机0-1000秒
            Thread.sleep(costTime);
            return costTime;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<MyTask2> tasks = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            tasks.add(new MyTask2());
        }
        ExecutorService execs = Executors.newCachedThreadPool();
        //获取futureList，指定超时时间500ms
        List<Future<Integer>> futures = execs.invokeAll(tasks, 500, TimeUnit.MILLISECONDS);

        for (Future<Integer> future : futures) {
            //每个任务，要么正常完成可以get到，要么isCancelled，此时get会报错java.util.concurrent.CancellationException
            if (future.isCancelled()) {
                System.out.println("is canceled,getResult:"+future.get());
            }else{
                Integer integer = future.get();
                System.out.println("costTime:" + integer);
            }
        }
    }
}
