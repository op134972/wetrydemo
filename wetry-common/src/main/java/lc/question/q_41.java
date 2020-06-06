package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-18 22:22
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class q_41 {

    public int firstMissingPositive(int[] nums) {
        int miss = 1;
        boolean[] arr = new boolean[getMax(nums)+1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            arr[nums[i]] = true;
            if (miss == nums[i]) {
                miss = nextMinMiss(miss,arr);
            }
        }
        return miss;
    }

    private int getMax(int[] nums) {
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    private int nextMinMiss(int miss, boolean[] arr) {
        for (int i = miss; i < arr.length; i++) {
            if (!arr[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        System.out.println(new q_41().firstMissingPositive(arr));

    }

}
