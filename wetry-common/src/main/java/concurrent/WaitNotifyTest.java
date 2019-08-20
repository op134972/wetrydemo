package concurrent;

/**
 * @Author: tangwenchuan
 * @Date: 2019-07-30 00:34
 */
public class WaitNotifyTest {

    public void testWait() throws InterruptedException {
        synchronized (this) {
            this.wait();
        }
    }

    public void testNotify(){
        synchronized (this) {
            this.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //应该会产生死锁
        WaitNotifyTest wt = new WaitNotifyTest();
        wt.testWait();
        wt.testNotify();
        System.out.println("done");
    }
}
