package lc.hard;

import java.util.*;

/**
 * @Author: tangwenchuan
 * @Date: 2020-10-09 16:38
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q140_单词拆分II_暴力 {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<List<String>> res = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(wordDict);
        wordBreak(res, new ArrayList<>(), s, wordSet, 0);

        List<String> finalRes = new ArrayList<>(res.size());
        if (res.size() != 0) {
            for (List<String> list : res) {
                StringBuilder ss = new StringBuilder();
                for (String s1 : list) {
                    ss.append(" ").append(s1);
                }
                finalRes.add(ss.toString().trim());
            }
        }
        return finalRes;
    }

    private void wordBreak(List<List<String>> res, List<String> subRes, String s, Set<String> wordSet, int start) {
        if (start == s.length()) {
            if (subRes != null && subRes.size() != 0) {
                res.add(new ArrayList<>(subRes));
            }
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (wordSet.contains(substring)) {
                subRes.add(substring);
                wordBreak(res, subRes, s, wordSet, i);
                subRes.remove(subRes.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        q140_单词拆分II_暴力 q140_单词拆分II_暴力 = new q140_单词拆分II_暴力();
        System.out.println(q140_单词拆分II_暴力.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")).toString());
        System.out.println(q140_单词拆分II_暴力.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")).toString());
        System.out.println(q140_单词拆分II_暴力.wordBreak("aaaa", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa")).toString());
    }

}
