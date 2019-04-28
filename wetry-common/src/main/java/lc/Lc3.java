package lc;

import java.util.HashMap;

/**
 * Created by tangwc on 2019/3/6.
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Lc3 {


    /**
     * 成功
     * 显示详情
     * 执行用时: 63 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了61.05% 的用户
     * 内存消耗: 50.5 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了12.45% 的用户
     */
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;
        int endIndex;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (charMap.containsKey(c)) {
                startIndex = Math.max(charMap.get(c) + 1, startIndex);
            }
            charMap.put(c, i);
            endIndex = i + 1;
            maxLength = Math.max(maxLength, endIndex - startIndex);
        }
        return maxLength;
    }

}
