package lc.q2;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-03 22:08
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 1. 二分查找，注意边界条件
 * 2. 若要AC需要考虑越界，通过long来解决
 */
public class q69_ac {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        return (int) fun(0, x, x);
    }

    private long fun(long l, long r, long x) {
        if (l >= r) {
            //边界判断
            if (r*r > x) {
                return r - 1;
            }
            return r;
        }
        long mid = (l + r) / 2;
        long mul = mid * mid;
        if (mul == x) {
            return mid;
        }
        if (mul > x) {
            return fun(l, mid-1, x);
        }
        return fun(mid+1, r, x);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ":" + new q69_ac().mySqrt(i));
        }
    }
}
