package concurrent;

import java.util.concurrent.*;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-30 23:00
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(10000);
                return 123;
            }
        });

        Thread t = new Thread(futureTask);
        t.start();
        System.out.println("waiting future task done.");
        System.out.println(futureTask.get(10, TimeUnit.SECONDS));
    }
}
