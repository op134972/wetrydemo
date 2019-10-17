package netty;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: tangwenchuan
 * @Date: 2019-09-25 10:59
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("在回调中执行耗时操作...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return 100;
        });
        completableFuture = completableFuture.thenCompose(i -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("在回调的回调中执行耗时操作...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                return i + 100;
            });
        });
        completableFuture = completableFuture.thenCompose(i -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("在回调的回调中执行耗时操作...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                return i + 100;
            });
        });

        completableFuture.whenComplete((result, e) -> {
            System.out.println("计算结果:" + result);
        });
        System.out.println("主线程运算耗时:" + (System.currentTimeMillis() - l) + " ms");
        new CountDownLatch(1).await();
    }

}
