package juc;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-11 17:16
 */
public class MyAtomicInteger {

    private volatile int val;

    private volatile int lockState = 0;

    public int incrAndGet() throws InterruptedException {
        int ov;
        do {
            ov = get();
        } while (!cas(ov, ov + 1));
        return ov + 1;
    }

    private boolean cas(int oldVal, int newVal) {
        if (lockState == 0) {
            lockState = 1;
            if (get() == oldVal) {
                this.val = newVal;
                lockState = 0;
                return true;
            }
        }
        return false;
    }

    public int get() {
        return val;
    }

}
