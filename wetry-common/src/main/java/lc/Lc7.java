package lc;

/**
 * Created by tangwc on 2019/3/7.
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class Lc7 {

    /**
     * 成功
     * 显示详情
     * 执行用时: 49 ms, 在Reverse Integer的Java提交中击败了26.20% 的用户
     * 内存消耗: 46 MB, 在Reverse Integer的Java提交中击败了0.95% 的用户
     */
    public int reverse(int x) {
        try {
            boolean negative = false;
            if (x < 0) {
                x = -x;
                negative = true;

            }
            String s = String.valueOf(x);
            String reverse = reverse(s);
            Integer integer = Integer.valueOf(reverse);
            if (negative) {
                return -integer;
            } else {
                return integer;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            sb.append(s.charAt(i--));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int reverse = new Lc7().reverse(-123332456);
        System.out.println(reverse);
    }
}
