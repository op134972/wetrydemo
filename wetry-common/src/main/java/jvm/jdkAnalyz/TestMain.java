package jvm.jdkAnalyz;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-19 23:43
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            Thread.sleep(1000);
        }
    }
}
