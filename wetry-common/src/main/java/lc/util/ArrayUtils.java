package lc.util;

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
        System.out.println("------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------------");
    }
}
