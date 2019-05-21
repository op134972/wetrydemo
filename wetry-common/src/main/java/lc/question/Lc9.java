package lc.question;

/**
 * Created by tangwc on 2019/3/8.
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Lc9 {

    /**
     * 成功
     * 显示详情
     * 执行用时: 144 ms, 在Palindrome Number的Java提交中击败了82.24% 的用户
     * 内存消耗: 39.8 MB, 在Palindrome Number的Java提交中击败了63.67% 的用户
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int[] arr = new int[32];
        int i = 0;
        while (x != 0) {
            arr[i++] = x % 10;
            x /= 10;
        }

        for (int i1 = 0; i1 < i - 1; i1++) {
            int j = i - 1 - i1;
            if (arr[i1] != arr[j]) {
                return false;
            }

            if (i1 >= j) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Lc9().isPalindrome(162));
        System.out.println(new Lc9().isPalindrome(161));
        System.out.println(new Lc9().isPalindrome(1));
        System.out.println(new Lc9().isPalindrome(0));
        System.out.println(new Lc9().isPalindrome(-162));
    }

}
