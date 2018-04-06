package common.lang.test;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;

import java.util.Arrays;

public class Demo1 {

    public static void main(String[] args) {

        //ArrayUtils
        Integer[] arr = new Integer[10];
        ArrayUtils.addAll(arr, new int[]{21, 3, 41, 2, 42});
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(BooleanUtils.toBoolean("hello"));
        System.out.println(BooleanUtils.toBoolean(""));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
