package jvm;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-09 23:11
 *
 * Xss160k  栈大小 ，栈帧包含本地变量表，栈帧太大，会导致层数变少
 *
 * 160k / 8字节 = 20000个。 理论
 */
public class StackOverFlowTest {

    private static int stackLength = 0;

    public static void main(String[] args) {
        try {
            stackLeak();
        } catch (Error e) {
            System.out.println("stackLength:"+stackLength);
            e.printStackTrace();
        }
    }


    public static void stackLeak(){


        long i100=100;

        stackLength++;
        stackLeak();
    }
}
