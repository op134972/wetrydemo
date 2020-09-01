package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 11:23
 */
public class MemLeakTest {

    private static List<Byte[]> list = new ArrayList<>(8);

    public static void addLeak(){
        Byte[] byteArr = new Byte[1024 * 1024];
        list.add(byteArr);
        byteArr = null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {

        }
    }

}
