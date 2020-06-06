package lc.question;

import java.util.*;

/**
 * @Author: tangwenchuan
 * @Date: 2019-05-21 10:20
 * <p>
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */
public class q_30 {

    /**
     *成功
     * 显示详情
     * 执行用时 : 572 ms, 在Substring with Concatenation of All Words的Java提交中击败了11.68% 的用户
     * 内存消耗 : 237.2 MB, 在Substring with Concatenation of All Words的Java提交中击败了6.25% 的用户
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if (s==null||s.length()==0 || words == null || words.length == 0 || words.length * words[0].length() > s.length()) {
            return Collections.emptyList();
        }
        Map<String, Integer> map = generateMap(words);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (withSubString(i, s, words,map)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean withSubString(int startIndex, String str, String[] words, Map<String, Integer> mapSrc) {
        Map<String, Integer> map = new HashMap<>(mapSrc);
        int wordLength = words[0].length();

        for (int i = startIndex; i <= str.length() - wordLength; i = i + wordLength) {
            String substring = str.substring(i, i + wordLength);
            Integer count = map.get(substring);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                map.remove(substring);
            }else{
                map.put(substring, count - 1);
            }
            if (map.size() == 0) {
                return true;
            }
        }
        return false;
    }

    private Map<String, Integer> generateMap(String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        return map;
    }


    public static void main(String[] args) {
        q_30 obj = new q_30();

        List<Integer> res = obj.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});

        System.out.println(res.toString());

    }

}
