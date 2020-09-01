package utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-10 19:56
 */
public class WetryThreadFactory implements ThreadFactory {

    private String name;

    private AtomicInteger count = new AtomicInteger(0);

    public WetryThreadFactory(String threadName) {
        this.name = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, name + count.getAndIncrement());
    }

}
