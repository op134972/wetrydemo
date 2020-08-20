package lc.q4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-20 13:41
 */
public class q139 {


    /**
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 81.37%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 74.16%
     * 的用户
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) {
            return true;
        }
        Set<String> wordSet = new HashSet<>(wordDict);

        //表示到0-i，是否可以用字典的单词组合
        boolean[] can = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            can[i] = checkPre(i, s, can, wordSet);
        }

        return can[s.length() - 1];
    }

    private boolean checkPre(int i, String s, boolean[] can, Set<String> wordSet) {
        int end = i + 1;
        while (i >= 0) {
            if (wordSet.contains(s.substring(i, end)) && (i - 1 < 0 || can[i - 1])) {
                return true;
            }
            i--;
        }
        return false;
    }

    /*递归，无异于暴力解法*/
    public boolean wordBreak2(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);

        return wordBreak(s, wordSet, 0);
    }

    private boolean wordBreak(String s, Set<String> wordSet, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordSet.contains(s.substring(start, i + 1)) && wordBreak(s, wordSet, i + 1)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        q139 q139 = new q139();
//        "applepenapple", wordDict = ["apple", "pen"]
        String word = "a";
        List<String> wd = new ArrayList<>();
        wd.add("a");
        wd.add("aa");

        System.out.println(q139.wordBreak(word, wd));
    }

}
