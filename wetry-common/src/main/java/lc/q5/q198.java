package lc.q5;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-25 22:40
 */
public class q198 {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.1 MB
     * , 在所有 Java 提交中击败了
     * 49.98%
     * 的用户
     */
    public int rob(int[] nums) {

        /**
         * 2,1,1,2
         * dp[i] = max(dp[i-2],dp[i-3])+nums[i]
         */
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int res = 0;
        int[] max = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i-2<0) {
                max[i] = nums[i];
            } else if (i - 3 < 0) {
                max[i] = max[i - 2] + nums[i];
            } else{
                max[i] = Math.max(max[i - 2], max[i - 3]) + nums[i];
            }
            res = Math.max(res, max[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        q198 q198 = new q198();
        System.out.println(q198.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(q198.rob(new int[]{1}));
        System.out.println(q198.rob(new int[]{1,2}));
        System.out.println(q198.rob(new int[]{1,2,3,4}));
        System.out.println(q198.rob(new int[]{2,1,1,2}));
        System.out.println(q198.rob(new int[]{}));
    }
}
