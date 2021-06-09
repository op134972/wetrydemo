package thread.cs;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @Author: tangwenchuan
 * @Date: 2021/6/4 3:08 下午
 */
public class CompleteFutureTest {


    public static void main(String[] args) {

    }

    /**
     * 1. 简单任务
     */
    @Test
    public void testSimpleCompletableFuture() {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello mghio");
        assertTrue(completableFuture.isDone());
        try {
            assertEquals("Hello mghio", completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2. 异步执行，不关心返回。可传入线程池，不传入，使用默认的ForkJoinPool.commonPool()
     */
    @Test
    public void testCompletableFutureRunAsync() {
        AtomicInteger variable = new AtomicInteger(0);
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> process(variable));
        runAsync.join();
        assertEquals(100, variable.get());
    }

    public void process(AtomicInteger variable) {
        System.out.println(Thread.currentThread() + " Process...");
        variable.set(100);
    }

    /**
     * 3.supplyAsync，异步执行
     * thenApply：有入参，关心返回
     * thenAccept：有入参，不关心返回
     * thenRun：无入参，不关心返回
     * * 链式调用和结果聚合处理
     * * 我们知道 CompletableFuture 的 get() 方法会一直阻塞直到获取到结果，CompletableFuture 提供了 thenApply、thenAccept
     * * 和 thenRun 等方法来避免这种情况，而且我们还可以添加任务完成后的回调通知。这几个方法的使用场景如下：
     * *
     * * thenApply 当我们如果要在从 Future 接收值后任务之前运行自定义的业务代码，然后要为此任务返回一些值时，则可以使用该方法
     * * thenAccept 如果我们希望在从 Future 接收到一些值后执行任务之前运行自定义的业务代码而不关心返回结果值时，则可以使用该方法
     * * thenRun 如果我们想在Future完成后运行自定义的业务代码，并且不想为此返回任何值时，则可以使用该方法
     */
    AtomicInteger variable = new AtomicInteger();

    @Test
    public void testCompletableFutureThenApply() {
        Integer notificationId = CompletableFuture.supplyAsync(this::thenApplyProcess)
                .thenApply(this::thenApplyNotify) // Non Blocking
                .join();
        assertEquals(new Integer(1), notificationId);
    }


    @Test
    public void testCompletableFutureThenAccept() {
        CompletableFuture.supplyAsync(this::processVariable)
                .thenAccept(this::thenAcceptNotify) // Non Blocking
                .join();
        assertEquals(100, variable.get());
    }

    @Test
    public void testCompletableFutureThenRun() {
        CompletableFuture.supplyAsync(this::processVariable)
                .thenRun(this::thenRunNotify)
                .join();
        assertEquals(100, variable.get());
    }


    private String processVariable() {
        variable.set(100);
        return "success";
    }

    private void thenRunNotify() {
        System.out.println("thenRun completed notify ....");
    }

    private Integer thenApplyNotify(Integer integer) {
        return integer;
    }

    private void thenAcceptNotify(String s) {
        System.out.println(
                String.format("Thread %s completed notify ....", Thread.currentThread().getName()));
    }

    public Integer thenApplyProcess() {
        return 1;
    }


    /**
     * 4. thenApply。thenApply。thenApply
     * 如果有大量的异步计算，那么我们可以继续将值从一个回调传递到另一个回调中去，也就是使用链式调用方式，使用方式很简单。
     */
    @Test
    public void testCompletableFutureThenApplyAccept() {
        CompletableFuture.supplyAsync(this::findAccountNumber)
                .thenApply(this::calculateBalance)//链式调用，一直往下传
                .thenApply(this::notifyBalance)
                .thenAccept((i) -> notifyByEmail()).join();
    }

    private void notifyByEmail() {
        // business code
        System.out.println("send notify by email ...");
    }

    private Double notifyBalance(Double d) {
        // business code
        System.out.println(String.format("your balance is $%s", d));
        return 9527D;
    }

    private Double calculateBalance(Object o) {
        // business code
        return 9527D;
    }

    private Double findAccountNumber() {
        // business code
        return 9527D;
    }


    /**
     * 5. 用额外的线程执行，异步的。thenApplyAsync
     */
    @Test
    public void testCompletableFutureApplyAsync() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors
                .newSingleThreadScheduledExecutor();
        CompletableFuture<Double> completableFuture =
                CompletableFuture
                        .supplyAsync(this::findAccountNumber,
                                newFixedThreadPool) // 从线程池 newFixedThreadPool 获取线程执行任务
                        .thenApplyAsync(this::calculateBalance,
                                newSingleThreadScheduledExecutor)
                        .thenApplyAsync(this::notifyBalance);
        Double balance = completableFuture.join();
        assertEquals(9527D, balance.doubleValue());
    }

    /**
     * 6. thenCompose，前后依赖，链式
     * thenCompose 方法适合有依赖性的任务处理，比如一个计算账户余额的业务：首先我们要先找到帐号，
     * 然后为该帐户计算余额，然后计算完成后再发送通知。所有这些任务都是依赖前一个任务的返回
     * CompletableFuture 结果，此时我们需要使用 thenCompose 方法，其实有点类似于 Java 8 流的
     * flatMap 操作。
     */
    @Test
    public void testCompletableFutureThenCompose() {
        Double balance = this.doFindAccountNumber()
                .thenCompose(this::doCalculateBalance)
                .thenCompose(this::doSendNotifyBalance).join();
        assertEquals(9527D, balance.doubleValue(),2);
    }

    private CompletableFuture<Double> doSendNotifyBalance(Double aDouble) {
        sleepSeconds(2);
        // business code
        System.out.println(String.format("%s doSendNotifyBalance ....", Thread.currentThread().getName()));
        return CompletableFuture.completedFuture(9527D);
    }

    private CompletableFuture<Double> doCalculateBalance(Double d) {
        sleepSeconds(2);
        // business code
        System.out.println(String.format("%s doCalculateBalance ....", Thread.currentThread().getName()));
        return CompletableFuture.completedFuture(9527D);
    }

    private CompletableFuture<Double> doFindAccountNumber() {
        sleepSeconds(2);
        // business code
        System.out.println(String.format("%s doFindAccountNumber ....", Thread.currentThread().getName()));
        return CompletableFuture.completedFuture(9527D);
    }

    private void sleepSeconds(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 7. thenCombine
     * thenCombine方法主要是用于合并多个独立任务的处理结果。假设我们需要查找一个人的姓名和住址，则可以使用不同的任务
     * 来分别获取，然后要获得这个人的完整信息（姓名 + 住址），则需要合并这两种方法的结果，那么我们可以使用 thenCombine 方法。
     */
    @Test
    public void testCompletableFutureThenCombine() {
        CompletableFuture<String> thenCombine = this.findName().thenCombine(this.findAddress(), (name, address) -> name + address);
        String personInfo = thenCombine.join();
        assertEquals("mghio Shanghai, China", personInfo);
    }

    private CompletableFuture<String> findAddress() {
        return CompletableFuture.supplyAsync(() -> {
            sleepSeconds(2);
            // business code
            return "Shanghai, China";
        });
    }

    private CompletableFuture<String> findName() {
        return CompletableFuture.supplyAsync(() -> {
            sleepSeconds(2);
            // business code
            return "mghio ";
        });
    }

    /**
     * 8. allOf
     */
    @Test
    public void testCompletableFutureAllof() {
        List<CompletableFuture<String>> list = Lists.newArrayListWithCapacity(4);
        IntStream.range(0, 3).forEach(num -> list.add(findName(num)));

        CompletableFuture<Void> allFuture = CompletableFuture
                .allOf(list.toArray(new CompletableFuture[0]));

        CompletableFuture<List<String>> allFutureList = allFuture
                .thenApply(val -> list.stream().map(CompletableFuture::join).collect(Collectors.toList()));

        CompletableFuture<String> futureHavingAllValues = allFutureList
                .thenApply(fn -> String.join("", fn));

        String result = futureHavingAllValues.join();
        assertEquals("mghio0mghio1mghio2", result);
    }

    private CompletableFuture<String> findName(int num) {
        return CompletableFuture.supplyAsync(() -> {
            sleepSeconds(2);
            // business code
            return "mghio" + num;
        });
    }


    /**
     * 9. 异常处理
     */
    @Test
    public void testCompletableFutureExceptionally() {
        CompletableFuture<Double> thenApply = CompletableFuture.supplyAsync(this::findAccountNumber)
                .thenApply(this::calculateBalance)
                .thenApply(this::notifyBalance)
                .exceptionally(ex -> {
                    System.out.println("Exception " + ex.getMessage());
                    return 0D;
                });
        Double join = thenApply.join();
        assertEquals(9527d, join, 2);
    }

    @Test
    public void testCompletableFutureHandle() {
        CompletableFuture.supplyAsync(this::findAccountNumber)
                .thenApply(this::calculateBalance)
                .thenApply(this::notifyBalance)
                .handle((ok, ex) -> {
                    System.out.println("最终要运行的代码...");
                    if (ok != null) {
                        System.out.println("No Exception !!");
                    } else {
                        System.out.println("Exception " + ex.getMessage());
                        return -1D;
                    }
                    return ok;
                });
    }


    @Test
    public void testCompletableFutureWhenComplete() {
        CompletableFuture.supplyAsync(this::findAccountNumber)
                .thenApply(this::calculateBalance)
                .thenApply(this::notifyBalance)
                .whenComplete((result, ex) -> {
                    System.out.println("result = " + result + ", ex = " + ex);
                    System.out.println("最终要运行的代码...");
                });
    }
}
