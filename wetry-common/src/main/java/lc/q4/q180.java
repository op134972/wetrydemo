package lc.q4;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-25 16:48
 */
public class q180 {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 40.5 MB
     * , 在所有 Java 提交中击败了
     * 24.84%
     * 的用户
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int temp;
            int index = i;
            int pre = nums[index];
            do {
                index = (index + k) % nums.length;
                temp = nums[index];
                nums[index] = pre;
                pre = temp;
                count++;
            } while (index != i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        /**
         * 1，2，3，4，5，6
         *
         */
        q180 q180 = new q180();
        q180.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));

    }

}
