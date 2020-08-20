package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-05-23 13:49
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class q32_ {

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length - 1, -1, -1, ')'));
    }

    private static int calc(char[] chars, int i, int flag, int end, char cTem) {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = max > validLen ? max : validLen;
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0) {
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }


    private int max(String s){
        char[] chars = s.toCharArray();
        int res = 0;
        for (int k = 0; k < chars.length; k++) {
            int i = k;
            int j = k + 1;
            int len = 0;
            while (i >= 0 && j <= chars.length - 1) {
                if (mirror(chars[i], chars[j])) {
                    len += 2;
                    res = Math.max(len, res);
                    i--;
                    j++;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    private boolean mirror(char l,char r){
        if ('(' == l) {
            return ')' == r;
        }
        if (')' == l) {
            return '(' == r;
        }
        return false;
    }

    public static void main(String[] args) {
        q32_ obj = new q32_();
        System.out.println(obj.max("(()"));
        System.out.println(obj.max("(())()()))(((()"));
        System.out.println(obj.max("(())(((())(())(((()"));
        System.out.println(obj.max("(()"));
    }
}
