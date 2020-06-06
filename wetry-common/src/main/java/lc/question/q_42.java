package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-19 21:40
 */
public class q_42 {


    /**
     * 思路1：
     * 暴力
     * 每个位置，向左向右找min(max1,max2)，累加
     */
    public int fun(int[] arr){
        // 0,1,0,2,1,0,1,3,2,1,2,1

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += find(arr, i)-arr[i];
        }

        return sum;
    }

    private int find(int[] arr, int i) {
        return Math.min(left(arr, i), right(arr,i));
    }

    private int right(int[] arr, int i) {
        int res = arr[i];
        while (i < arr.length) {
            res = Math.max(arr[i++], res);
        }
        return res;
    }

    private int left(int[] arr, int i) {
        int res = arr[i];
        while (i >= 0) {
            res = Math.max(arr[i--], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new q_42().fun(arr));
    }
}
