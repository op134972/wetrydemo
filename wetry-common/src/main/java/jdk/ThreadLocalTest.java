package jdk;

import org.apache.commons.lang3.StringUtils;
import utils.WetryThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-10 19:54
 */
public class ThreadLocalTest {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    private static ThreadPoolExecutor executors = new ThreadPoolExecutor(4, 16, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), new WetryThreadFactory("thread-local-test-"), new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            executors.execute(() -> {
                String s = threadLocal.get();
                if (StringUtils.isEmpty(s)) {
                    System.out.println("from s is null, set one");
                    threadLocal.set(Thread.currentThread().getName());
                }
                System.out.println(s);
                //这里不删除的话，只会set 4次， 线程复用，后续线程能 get 最开始线程set的值。
//                threadLocal.remove();
            });
        }

        System.out.println("done");

        Thread.sleep(1000);

        System.out.println(executors.getQueue().size());

//        for (int i = 0; i < 100; i++) {
//            int finalI = i;
//            executors.execute(new Runnable() {
//                @Override
//                public void run() {
//                    String name = finalI % 10 + "";
//                    String str = ThreadLocalHelper.get(name, String.class);
//                    if (StringUtils.isEmpty(str)) {
//                        ThreadLocalHelper.set(name, Thread.currentThread().getName());
//                    }
//                    System.out.println(str);
//                }
//            });
//        }
    }
}
