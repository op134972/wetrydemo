package lc.question;

/**
 * Created by tangwc on 2019/3/9.
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class q14 {

    /**
     * 找最优解
     * 1. 二分法+startWith
     * abc
     * ab
     *
     * 一种骚操作：
     * 先排序，再比较第一个和最后一个str就可以。
     *
     */
    public String longestCommonPrefix(String[] strs) {
        int minLength = getMinLengh(strs);

        int i = 1;
        int j = minLength;
        int mid = (i+j)/2;
        while (i <= j) {
            mid = (i + j) / 2;
            if (samePrefix(strs,mid)) {
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return strs[0].substring(0, Math.min(Math.min(mid, j), i));
    }

    private boolean samePrefix(String[] strs, int index) {
        String prefix = "";
        for (String str : strs) {
            if (prefix.length() == 0) {
                prefix = str.substring(0,index);
                continue;
            }
            //这里可以优化一下 ，只比较a,b之间的区域
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    private int getMinLengh(String[] strs) {
        int length = 0;
        for (String str : strs) {
            length = Math.max(length, str.length());
        }
        return length;
    }

    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "a";
        strs[1] = "b";
        strs[2] = "c";

        System.out.println(new q14().longestCommonPrefix(strs));

    }

}
