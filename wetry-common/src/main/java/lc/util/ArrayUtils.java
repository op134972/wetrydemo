package lc.util;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-27 21:57
 */
public class ArrayUtils {

    public static void printArr(int[][] arr){
        if (arr == null) {
            System.out.println("arr null");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
