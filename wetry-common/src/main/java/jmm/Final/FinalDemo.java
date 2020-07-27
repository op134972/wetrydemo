package jmm.Final;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-24 00:00
 */
public class FinalDemo {

    private int a;                        //普通变量
    private final int b;                  //final变量
    private static FinalDemo finalDemo;

    public FinalDemo() {      //构造函数
        a = 1;                //写普通域
        b = 2;                //写final域
    }

    public static void write() {    //写线程A执行
        finalDemo = new FinalDemo();
    }

    public static void read() {        //读线程B执行
        FinalDemo object = finalDemo;    //读对象引用
        int a = object.a;                //读普通域
        int b = object.b;               //读final域
        System.out.println(finalDemo);
    }


    public static void main(String[] args) throws InterruptedException {
        /**
         * 使用两个线程
         * A线程不停的write，构造对象引用
         * B线程不停的read，看读到的对象是否状态正确
         */

        Thread tA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    FinalDemo.write();
                }
            }
        });

        Thread tB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    FinalDemo.read();
                }
            }
        });

        tA.start();
        tB.start();
        tB.join();

    }

}
