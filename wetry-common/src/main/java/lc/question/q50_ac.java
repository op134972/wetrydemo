package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-03 13:57
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 链接：https://leetcode-cn.com/problems/powx-n
 *
 * 优化点（减少乘法的次数）
 * 幂上的二分
 */
public class q50_ac {

    public double myPow(double x, int c) {
        long n = c;
        if (n == 0) {
            return 1;
        }

        double res;
        boolean pos = false;
        if (n < 0) {
            pos = true;
            n = -n;
        }

        if (n % 2 == 1) {
            res = myPow(x, (int) (n / 2));
            res = res * res *  x;
        }else{
            res = myPow(x, (int) (n / 2));
            res *= res;
        }

        return pos ? (double) 1 / res : res;
    }

    public static void main(String[] args) {
        System.out.println(new q50_ac().myPow(2.1, 3));
    }
}
