package lc.question;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-10 16:35
 *
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class q66 {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 86.96%
     * 的用户
     */
    public int[] plusOne(int[] digits) {

        boolean carry = false;

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (i == digits.length - 1) {
                if (digit == 9) {
                    digits[i] = 0;
                    carry = true;
                }else{
                    digits[i] = digit + 1;
                }
            } else if (carry) {
                if (digit == 9) {
                    digits[i] = 0;
                    carry = true;
                }else{
                    digits[i] = digit + 1;
                    carry = false;
                }
            }
        }

        if (carry) {
            //最高位+1
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }else{
            return digits;
        }
    }


    public static void main(String[] args) {
        q66 q66 = new q66();
        System.out.println(Arrays.toString(q66.plusOne(new int[]{9, 9, 9, 9})));
    }

}
