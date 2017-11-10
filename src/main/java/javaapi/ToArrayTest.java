package javaapi;

import java.util.ArrayList;
import java.util.List;

public class ToArrayTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("1");
        list.add("2");
        Object[] objects = list.toArray();
        //String[] arr = list.toArray(new String[0]);// 1、会重新分配内存
        String[] arr = list.toArray(new String[list.size()]);
    }
}
