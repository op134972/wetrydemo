package juc;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-11 17:16
 */
public class MyAtomicInteger {

    private volatile int val;

    public int incrAndGet() throws InterruptedException {
        int ov;
        do {
            ov = get();
        } while (!cas(ov, ov + 1));
        return ov + 1;
    }

    private boolean cas(int oldVal, int newVal) {
        if (get() == oldVal) {
            this.val = newVal;
            return true;
        }
        return false;
    }

    public int get() {
        return val;
    }

}
