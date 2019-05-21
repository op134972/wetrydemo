package lc.question;

/**
 * Created by tangwc on 2019/3/7.
 * 最长回文串
 * <p>
 * 成功
 * 显示详情
 * 执行用时: 75 ms, 在Longest Palindromic Substring的Java提交中击败了48.38% 的用户
 * 内存消耗: 40.2 MB, 在Longest Palindromic Substring的Java提交中击败了11.12% 的用户
 */
public class Lc5 {


    /**
     * 成功
     * 显示详情
     * 执行用时: 75 ms, 在Longest Palindromic Substring的Java提交中击败了48.38% 的用户
     * 内存消耗: 40.2 MB, 在Longest Palindromic Substring的Java提交中击败了11.12% 的用户
     */
    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = 1;
        int b = 0, e = 0;
        for (int i = 0; i < str.length(); i++) {
            int p = i, q = i;
            int l;
            while (p >= 0 && q < str.length() && str.charAt(p) == str.charAt(q)) {
                l = q - p + 1;
                if (l > length) {
                    b = p;
                    e = q;
                    length = l;
                }
                p--;
                q++;
            }
            p = i;
            q = i + 1;
            while (p >= 0 && q < str.length() && str.charAt(p) == str.charAt(q)) {
                l = q - p + 1;
                if (l > length) {
                    b = p;
                    e = q;
                    length = l;
                }
                p--;
                q++;
            }
        }

        return str.substring(b, e + 1);
    }

}
