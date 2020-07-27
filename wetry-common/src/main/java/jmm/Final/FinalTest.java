package jmm.Final;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 23:42
 */
public class FinalTest {

//    private final int a;//final域
    private int b;//普通域

    private static FinalTest instance;

    private FinalTest() {
//        a = 1;
        b = 10000;
    }

    public static void write(){
        instance = new FinalTest();
//        System.out.println("write instance" + instance);
    }

    public static FinalTest read(){
        return instance;
    }

    @Override
    public String toString() {
        return "FinalTest{" +
//                "a=" + a +
                ", b=" + b +
                '}';
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
                while (true) {
                    FinalTest.write();
                }
            }
        });

        Thread tB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    FinalTest read = FinalTest.read();
                    if (read.b != 10000) {
                        System.out.println(read);
                    }
                }
            }
        });

        tA.start();
        tB.start();

    }
}
