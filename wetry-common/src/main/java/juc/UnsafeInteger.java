package juc;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-11 17:38
 */
public class UnsafeInteger {

    private int val;

    public int incrAndGet() throws InterruptedException {
        return ++val;
    }

    public int get() {
        return val;
    }
}
