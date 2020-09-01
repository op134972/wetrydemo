package lc.q4;

import lc.util.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-19 12:50
 */
public class q134 {

    //会超出内存限制，需要优化
    public int canCompleteCircuit2(int[] gas, int[] cost) {

        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }

        int[][] dp = new int[gas.length][gas.length];
        /**
         *  1. dp[i][j] 表示 i到j，还剩余的汽油数量
         *  2. 最终需要找到 dp[i][i]>=0的i即为返回值
         *  3. dp[i][i+1]作为初始化
         *  4. 状态转换：dp[i][j] = dp[i][j-1]+gas[j]-cost[j-1]
         */

        //初始化 0-1 1-2 2-3 3-4 ... 注意到末尾复位第一位
        Set<Integer> skip = new HashSet<>();
        for (int i = 0; i < dp.length; i++) {
            int i1 = gas[i] - cost[i];
            if (i1 < 0) {
                skip.add(i);
                continue;
            }
            dp[i][(i + 1) % (dp.length)] = i1;
        }

        ArrayUtils.printArr(dp);

        for (int i = 0; i < dp.length; i++) {
            if (skip.contains(i)) {
                continue;
            }
            //j表示距离i的增量
            for (int j = 2; j <= dp.length; j++) {
                dp[i][(i + j) % dp.length] = dp[i][(i + j - 1) % dp.length] + gas[(i + j - 1) % dp.length] - cost[(i + j - 1) % dp.length];
            }
        }

        ArrayUtils.printArr(dp);


        for (int i = 0; i < dp.length; i++) {
            if (skip.contains(i)) {
                continue;
            }
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j] < 0) {
                    break;
                }
                if (j == dp.length - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    /*
     * 执行用时：
     * 143 ms
     * , 在所有 Java 提交中击败了
     * 14.04%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 74.80%
     * 的用户
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        if (gas.length == 1 && gas[0] >= cost[0]) {
            return 0;
        }

        int[] arr = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            int i1 = gas[i] - cost[i];
            if (i1 < 0) {
                continue;
            }
            arr[(i + 1) % (arr.length)] = i1;
            for (int j = 2; j <= arr.length; j++) {
                int val = arr[(i + j - 1) % arr.length] + gas[(i + j - 1) % arr.length] - cost[(i + j - 1) % arr.length];
                if (val < 0) {
                    //及时跳出
                    break;
                }
                arr[(i + j) % arr.length] = val;
                if (j == arr.length) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        q134 q134 = new q134();
        int[] arr1 = {4};
        int[] arr2 = {4};
        int res = q134.canCompleteCircuit(arr1, arr2);
        System.out.println(res);
    }
}
