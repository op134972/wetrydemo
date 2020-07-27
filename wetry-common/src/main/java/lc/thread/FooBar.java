package lc.thread;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-24 22:30
 */
public class FooBar {

    private int n;

    private volatile int mutex;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (mutex == 0) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                mutex = 1;
                printFoo.notifyAll();
            }else{
                printFoo.wait();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            if (mutex == 1) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                mutex = 0;
                printBar.notifyAll();
            }else{
                printBar.wait();
            }
        }
    }
}
