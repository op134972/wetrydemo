package lc.question;

import java.util.Stack;

/**
 * Created by tangwc on 2019/3/14.
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class q20 {

    /**
     * 成功
     * 显示详情
     * 执行用时 : 10 ms, 在Valid Parentheses的Java提交中击败了66.97% 的用户
     * 内存消耗 : 35.6 MB, 在Valid Parentheses的Java提交中击败了2.40% 的用户
     */
    public boolean isValid(String s) {
        try {
            char[] chars = s.toCharArray();

            /**
             * 利用栈可以完成判断
             * "(" 1
             * "{" 2
             * "[" 3
             * ")" -1
             * "}" -2
             * "]" -3
             */

            Stack<Integer> stack = new Stack<>();
            for (char c : chars) {
                if (c == ' ') {
                    continue;
                }
                if (c == '(') {
                    stack.push(1);
                } else if (c == '{') {
                    stack.push(2);
                } else if (c == '[') {
                    stack.push(3);
                } else if (c == ')') {
                    Integer poll = stack.pop();
                    if (poll != 1) {
                        return false;
                    }
                } else if (c == '}') {
                    Integer poll = stack.pop();
                    if (poll != 2) {
                        return false;
                    }
                } else if (c == ']') {
                    Integer poll = stack.pop();
                    if (poll != 3) {
                        return false;
                    }
                }

            }
            return stack.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     */

    public static void main(String[] args) {
        System.out.println(new q20().isValid("([)]"));
    }


}
