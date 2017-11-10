package demo1;

import java.util.Arrays;

public class BinInsert {


    public static void is(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int index = findInsertIndex(arr, 0, i, arr[i]);
            for (int j = i; j > index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[index] = arr[i];
        }
    }

    private static int findInsertIndex(int[] arr, int start, int end, int target) {
        /*int mid = start + (end - start) / 2;
        while (start <= end) {
            if (arr[mid] > target) {
                end = mid - 1;
            } else if(arr[mid] == target){
                start = mid;
            }else{
                start = mid +1;
            }
        }*/

        int index = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] > target) {
                break;
            }else{
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 2, 5, 34, 21, 1};
        is(arr);
        System.out.println(Arrays.toString(arr));
    }
}
