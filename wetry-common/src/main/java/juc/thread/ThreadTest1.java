package juc.thread;

/**
 * Created by tangwc on 2020/6/13.
 */
public class ThreadTest1 {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread runing ...");
            }
        });

        thread.start();

        //wait
        thread.join();
        System.out.println("main done");
    }
}
