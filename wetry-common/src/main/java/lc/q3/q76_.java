package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-10 22:00
 * <p>
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class q76_ {

    /**
     * 思路1：
     * 假设：目标串最短，目标子串也一定最短。 假设错误 ADOBCODEBAN 最短AB 与最终结果不一致
     * <p>
     * 思路2：
     * ADOBECODEBANC
     * A  B C   BA C
     * 0123456789111  下标
     * 012  下标
     * <p>
     * A: 0,10
     * B: 3,9
     * C: 5,12
     * <p>
     * 思路是错的！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
     * <p>
     * 思路3：
     * 滑动窗口，双指针，left right 交替找最短字符串。
     */
    public String minWindow(String s, String t) {

        int left = 0, right = 0;

        int[] targetArr = new int[128];
        char[] tChar = t.toCharArray();
        for (int i = 0; i < tChar.length; i++) {
            targetArr[tChar[i]]++;
        }

        int count = 0;
        int[] rangeArr = new int[128];

        char[] chars = s.toCharArray();

        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;

        while (right < chars.length) {
            while (right < chars.length) {
                char rChar = chars[right];
                if (targetArr[rChar] != 0) {
                    if (rangeArr[rChar] < targetArr[rChar]) {
                        count++;
                    }
                    rangeArr[rChar]++;
                }

                right++;

                if (count == t.length()) {
                    //此时right已经+1了
                    int length = right - left;
                    minLength = Math.min(minLength, length);
                    if (minLength == length) {
                        //包头不包尾
                        minLeft = left;
                        minRight = right;
                    }
                    break;
                }

            }

            /**
             * ADOBCDEBANCC
             * 0123456789
             */
            while (count == t.length()) {
                char lChar = chars[left];
                left++;
                if (targetArr[lChar] != 0) {
                    rangeArr[lChar]--;
                    if (rangeArr[lChar] < targetArr[lChar]) {
                        count--;
                    } else {
                        int length = right - left;
                        minLength = Math.min(minLength, length);
                        if (minLength == length) {
                            minLeft = left;
                            minRight = right;
                        }
                    }
                }
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minLeft, minRight);
    }

    public String minWindow2(String s, String t) {


        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        String res = "";

        //目前有多少个字符
        int count = 0;

        //用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }
            right++;


            //移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left < minLength) {
                    minLength = right - left;
                    res = s.substring(left, right);

                }
                window[ch]--;
                left++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        q76_ q76_ = new q76_();
        System.out.println(q76_.minWindow("ADOBCDEBANCCCC", "ABC"));
        System.out.println(q76_.minWindow2("ADOBCDEBANCCCC", "ABC"));
//        System.out.println(q76_.minWindow("ABC", "A"));
//        System.out.println("ADOBCDEBANCC".substring(0, 5));
    }
}
