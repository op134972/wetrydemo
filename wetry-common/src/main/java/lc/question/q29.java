package lc.question;

import org.junit.Assert;

/**
 * @Author: tangwenchuan
 * @Date: 2019-05-20 19:05
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 *
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 37.1 MB
 * , 在所有 Java 提交中击败了
 * 38.72%
 * 的用户
 */
public class q29 {


    public int divide(int dividend, int divisor) {
        long divisorLong = divisor;
        long dividendLong = dividend;

        boolean neg1 = false;
        if (dividendLong < 0L) {
            dividendLong = -dividendLong;
            neg1 = true;
        }
        boolean neg2 = false;
        if (divisorLong < 0L) {
            divisorLong = -divisorLong;
            neg2 = true;
        }

        long diff = dividendLong;
        long res = 0;
        long originDivisor = divisorLong;
        int bit = 0;
        while (diff > 0) {
            //往上找最大减数
            while (divisorLong <= diff) {
                divisorLong = divisorLong << 1;
                bit++;
            }

            //divisor 大于 diff
            if (bit > 0) {
                //回滚一位
                divisorLong = divisorLong >> 1;
                res += 1L << (bit - 1);
            }
            diff -= divisorLong;

            divisorLong = originDivisor;
            bit = 0;
        }
        if (neg1 ^ neg2) {
            return -res < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -res;
        }
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }


    public static void main(String[] args) {
        q29 q29 = new q29();
//            int divided = RandomUtils.nextInt(-10000, 10000);
//            int divisor = RandomUtils.nextInt(-100, 100);
            int divided = -2147483648;
            int divisor = -1;
            int res1 = q29.divide(divided, divisor);
            int res2 = divided / divisor;
            System.out.println(divided + "/" + divisor + ":" + res1 + "==" + res2);
            Assert.assertEquals(res1, res2);
    }

}
