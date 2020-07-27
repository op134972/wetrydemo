package jvm;

import java.lang.ref.WeakReference;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 19:04
 */
public class WeakRefTest {

    public static void main(String[] args) {
        Object obj = new Object();
        WeakReference<Object> wr = new WeakReference<>(obj);
        obj = null;

        System.gc();

        System.out.println(obj);
        System.out.println(wr);
    }
}
