package thread.interrupt;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-27 23:14
 */
public class VolatileCancelTest extends Thread{

    volatile boolean cancel = false;

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void cancel(){
        this.cancel = true;
    }

    public void addQueue(Integer ele) throws InterruptedException {
        while (!cancel) {
            //put阻塞时候，无法检测cancel处理取消
            queue.put(ele);
        }
    }
}
