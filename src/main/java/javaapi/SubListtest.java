package javaapi;

import java.util.ArrayList;
import java.util.List;

public class SubListtest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<String> subList = list.subList(0, 3);
        System.out.println(subList.size());
        //list.remove(list.size() - 1);// 3、原列表的修改会导致视图的增加和修改都跑出concurrentModification的异常
        list.set(3,"4");// 4、原数组不改变大小，不会报错
        subList.add("3");// 2、虽然sublist只是个视图，但是subList的操作会影响到源列表

        System.out.println(list.size());// 1、包头不包尾
        System.out.println(list.toString());
    }
}
