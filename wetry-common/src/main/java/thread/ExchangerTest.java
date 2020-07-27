package thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeoutException;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-26 18:12
 */
public class ExchangerTest {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) throws InterruptedException, TimeoutException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String exchange = exchanger.exchange("a");
                    System.out.println("线程1拿a换回了：" + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t1.start();

        Thread.sleep(2000);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String exchange = exchanger.exchange("b");
                    System.out.println("线程2拿b换回了：" + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t2.start();
    }
}
