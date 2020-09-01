package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-10 16:26
 *
 * m*n的网格，从左上到右下 有几种路径
 *
 * 3，2 -> 3
 */
public class q62 {

    /*
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 36.1 MB
     * , 在所有 Java 提交中击败了
     * 99.05%
     * 的用户
     */
    public int uniquePaths(int m, int n) {

        /**
         * 一个格子，只可能是 从上，左到达，因此 dp[i][j] = dp[i][j-1]+dp[i-1][j]
         */

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        q62 q62 = new q62();
        System.out.println(q62.uniquePaths(7, 3));
    }
}
