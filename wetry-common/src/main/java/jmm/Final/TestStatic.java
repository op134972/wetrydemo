package jmm.Final;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-25 10:42
 */
public class TestStatic {

    private static Object obj;


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(obj);
            obj = new Object();
        }
    }
}
