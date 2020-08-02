package thread.interrupt;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-27 23:17
 */
public class InterruptCancelTest extends Thread{

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void cancel(){
        interrupt();
    }

    public void addQueue(Integer ele) {
        while (!Thread.currentThread().isInterrupted()) {
            //put阻塞时候，无法检测cancel处理取消
            try {
                queue.put(ele);
            } catch (InterruptedException e) {
                //响应中断
            }
        }
    }
}
