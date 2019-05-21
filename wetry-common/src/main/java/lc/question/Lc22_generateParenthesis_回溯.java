package lc.question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangwc on 2019/3/14.
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Lc22_generateParenthesis_回溯 {


    /**
     * 成功
     * 显示详情
     * 执行用时 : 4 ms, 在Generate Parentheses的Java提交中击败了66.07% 的用户
     * 内存消耗 : 37.2 MB, 在Generate Parentheses的Java提交中击败了0.98% 的用户
     */
    public List<String> generateParenthesis(int n) {


        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            res.add(str);
            return;
        }

        if (open < max) {
            backTrack(res, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backTrack(res, str + ")", open, close + 1, max);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Lc22_generateParenthesis_回溯().generateParenthesis(3));
    }

}
