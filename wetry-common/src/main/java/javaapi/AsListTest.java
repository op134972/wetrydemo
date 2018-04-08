package javaapi;

import java.util.Arrays;
import java.util.List;

public class AsListTest {
    public static void main(String[] args) {
        String [] arr = {"",""};
        List<String> strings = Arrays.asList(arr);
        strings.add("");

        //adList返回的是不可修改的list。
    }
}
