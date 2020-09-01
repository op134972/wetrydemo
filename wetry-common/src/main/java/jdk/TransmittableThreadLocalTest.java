package jdk;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-28 15:33
 */
public class TransmittableThreadLocalTest {

    static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(100));

    static TransmittableThreadLocal<String> tl = new TransmittableThreadLocal<>();
    static TransmittableThreadLocal<String> tl2 = new TransmittableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        testExecutors();

        sleep(10);
        System.out.println("---------------------------------------------");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程：" + Thread.currentThread().getName() + ", get:" + tl2.get());
            }
        });

        t1.run();
        sleep(10);
    }

    private static void testExecutors() throws InterruptedException {
        //        tl.set("1");//后期set 也能拿到 和InheritableThreadLocal不一样

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("当前线程：" + Thread.currentThread().getName() + ", get：" + tl.get());
                        }
                    });
                }
            }
        });
        t1.run();

        sleep(10);

        tl.set("2");
        t1.run();
    }

    static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
