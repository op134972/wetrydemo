package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-27 21:37
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 1. 思路一，使用dp[][] 二维数组，dp[i][j]若能被整除 且 A[j+1]能被整除，则dp[i][j+1]能被整除
 * 但是，提交提示内存超出限制
 *
 * 2. 思路没错，但是dp[i][j]太浪费内存了，其实用一个数就可以。记录dp[i][j]的值
 * 但是，仍然超出内存， 估计是计算 mod的时候 太费，再次优化
 *
 * 3. 思路仍没错，计算mod 可以继续优化， 如果s[i:j]能被整除，则只需要判断A[j+1]是否能被整除，如果可以，则能被整除。
 * 使用mod记录 余数， 就不用记录之前那么多数的和了
 *
 * 4. 思路不对，o(n2)复杂度太高
 *
 * 5. 前缀和 + 优化
 */
public class lc_974 {

    public int subarraysDivByK1(int[] A, int K) {


        int[][] dp = new int[A.length][A.length];

        /**
         * dp[i][j] 表示  i---j 的和
         */
        int res = 0;
        int mod = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i][i] = A[i];
            if (dp[i][i] == 0 || dp[i][i] % K == 0) {
                res++;
            }
            for (int j = i + 1; j < A.length; j++) {
                dp[i][j] = dp[i][j - 1] + A[j];
                if (dp[i][j] == 0 || dp[i][j] % K == 0) {
                    res++;
                }
            }
        }


        return res;
    }

    public int subarraysDivByK2(int[] A, int K) {



        /**
         * sum代替二维数组
         */
        int res = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
             sum = A[i];
            if (sum % K == 0) {
                res++;
            }
            for (int j = i + 1; j < A.length; j++) {
                sum = sum + A[j];
                if (sum % K == 0) {
                    res++;
                }
            }
        }


        return res;
    }

    public int subarraysDivByK3(int[] A, int K) {



        /**
         * sum代替二维数组
         */
        int res = 0;
        int mod;
        for (int i = 0; i < A.length; i++) {
            mod = A[i] % K;
            if (mod == 0) {
                res++;
            }
            for (int j = i + 1; j < A.length; j++) {
                mod = (mod + A[j])%K;
                if (mod == 0) {
                    res++;
                }
            }
        }


        return res;
    }

    public int subarraysDivByK4(int[] A, int K) {



        return 0;

    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int res = new lc_974().subarraysDivByK1(arr, 5);
        System.out.println(res);
        int res2 = new lc_974().subarraysDivByK2(arr, 5);
        System.out.println(res2);
        int res3 = new lc_974().subarraysDivByK3(arr, 5);
        System.out.println(res3);
    }

}
