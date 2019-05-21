package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-05-20 18:43
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Lc_28 {


    /**
     * 显示详情
     * 执行用时 : 2 ms, 在Implement strStr()的Java提交中击败了84.16% 的用户
     * 内存消耗 : 35.8 MB, 在Implement strStr()的Java提交中击败了84.43% 的用户
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        char[] hstr = haystack.toCharArray();
        char[] nstr = needle.toCharArray();
        int index = 0;
        for (int i = 0; i < hstr.length; i++) {
            if (hstr[i] == nstr[index]) {
                if (index == nstr.length - 1) {
                    return i - index;
                }
                index++;
            } else {
                if (index != 0) {
                    i -= index;
                }
                index = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Lc_28().strStr("aabaa", "ba");
        System.out.println(i);
    }

}
