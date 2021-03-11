package lc.q4;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-22 22:43
 */
public class q152 {


    //最终优化，dpMin[] dpMax[] 优化为iMin，iMax
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int iMin = nums[0];//记录到i为止 最大的 ，在：dpMax[i-1]*val, val , dpMax[i-1]*val 中产生
        int iMax = nums[0];//记录到i为止 最小的 ，在：dpMax[i-1]*val, val , dpMax[i-1]*val 中产生

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            int c1 = iMax * val;
            int c2 = iMin * val;

            iMax = Math.max(Math.max(c1, c2), val);
            iMin = Math.min(Math.min(c1, c2), val);


            max = Math.max(iMax, max);
        }

        return max;
    }

    /*
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 89.21%
     * 的用户
     * 内存消耗：
     * 39.7 MB
     * , 在所有 Java 提交中击败了
     * 89.12%
     * 的用户
     */
    public int maxProduct2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dpMin = new int[nums.length];//记录到i为止 最大的 ，在：dpMax[i-1]*val, val , dpMax[i-1]*val 中产生
        dpMin[0] = nums[0];
        int[] dpMax = new int[nums.length];//记录到i为止 最小的 ，在：dpMax[i-1]*val, val , dpMax[i-1]*val 中产生
        dpMax[0] = nums[0];

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            int c1 = dpMax[i - 1] * val;
            int c2 = dpMin[i - 1] * val;

            dpMax[i] = Math.max(Math.max(c1, c2), val);
            dpMin[i] = Math.min(Math.min(c1, c2), val);


            max = Math.max(dpMax[i], max);
        }

        return max;
    }


    //o(n^2)超时
    public int maxProduct1(int[] nums) {
        //2,3,-3,100,-3

        int max = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = dp[i][j - 1] * nums[j];
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        q152 q152 = new q152();
        System.out.println(q152.maxProduct(new int[]{-2, 0, -1}));
    }
}
