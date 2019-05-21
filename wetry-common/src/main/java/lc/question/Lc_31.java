package lc.question;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2019-05-21 11:33
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 123 → 132
 * 321 → 123
 * 115 → 151
 * 13222  21223
 * 14652    21456
 * 230241  230412
 */
public class Lc_31 {


    public void nextPermutation(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {
            int lessIndex = lessCharIndex(i, nums);
            if (lessIndex != -1) {
                exchangeEle(i, lessIndex, nums);
                subSort(nums, lessIndex);
                return;
            }
        }
        reverseArr(nums);
    }

    private void subSort(int[] nums, int endIndex) {
        for (int i = nums.length-1; i > endIndex ; i--) {
            for (int j = i-1; j > endIndex ; j--) {
                if (nums[j] > nums[i]) {
                    exchangeEle(i, j, nums);
                }
            }
        }
    }

    private void reverseArr(int[] nums) {
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            exchangeEle(i, j, nums);
        }
    }

    private void exchangeEle(int i1, int i2, int[] nums) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    private int lessCharIndex(int targetI, int[] nums) {
        int target = nums[targetI];
        for (int i = targetI-1; i >= 0; i--) {
            int num = nums[i];
            if (num >= target) {
                return -1;
            } else{
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,2,2};
        Lc_31 obj = new Lc_31();
        obj.nextPermutation(arr);

        System.out.println(Arrays.toString(arr));
    }

}
