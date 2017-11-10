package algorithm;

import java.util.Arrays;

public class Demo1 {

    public static int maxSubArraySum(int[] arr) {
        int maxSum = arr[0];
        int preSum;
        for (int i = 1; i < arr.length; i++) {
            preSum = maxSum + arr[i];
            if (preSum <= 0) {
                preSum = 0;
            }
            maxSum = Math.max(maxSum, preSum);
        }

        return maxSum;
    }


    public static int moreThanHalfNum(int[] arr) {

        return moreThanHalfNum(arr, 0, arr.length - 1);

    }

    private static int moreThanHalfNum(int[] arr, int start, int end) {
        int i = partition(arr, 0, arr.length - 1);
        int len = arr.length;
        if (len % 2 == 0) {//偶
            while (i != len / 2 - 1) {
                if (i > len / 2 - 1) {
                    i = partition(arr, start, i - 1);
                } else {
                    i = partition(arr, i + 1, end);
                }
            }
        } else {
            while (i != len / 2) {
                if (i > len / 2) {
                    i = partition(arr, start, i - 1);
                } else {
                    i = partition(arr, i + 1, end);
                }
            }
        }

        return arr[i];
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[i] >= pivot) {
                i++;
            }
            while (i < j && arr[j] <= pivot) {
                j--;
            }
            if (i > j) {
                swap(arr, i, j);
            } else {
                break;
            }
        }
        swap(arr, start, i);
        return i;
    }

    public static void funBubb(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
    }

    public static void funIns(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int insert = arr[i];
            int j;
            boolean flag = true;
            for (j = i - 1; j >= 0 && arr[j] > insert; j--) {
                arr[j + 1] = arr[j];
                flag = false;
            }
            arr[j + 1] = insert;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(maxSubArraySum(arr));

        System.out.println("================================================");

        int[] arr2 = {3, 3, 5};
        System.out.println(moreThanHalfNum(arr2));

        System.out.println("================================================");

        int[] arr3 = {13, 3, 6, 2, 1};
        funIns(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
