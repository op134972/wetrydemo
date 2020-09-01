package lc.q3;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-18 23:49
 */
public class q131 {

    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        char[] chars = s.toCharArray();

        bc(res, chars, 0, new ArrayList<>());

        return res;
    }

    private void bc(List<List<String>> res, char[] chars, int start, List<String> subRes) {
        if (start == chars.length) {
            if (CollectionUtils.isNotEmpty(subRes)) {
                res.add(new ArrayList<>(subRes));
            }
            return;
        }
        for (int i = start; i < chars.length; i++) {
            if (isHuiwen(chars, start, i)) {
                subRes.add(toString(chars, start, i));
                bc(res, chars, i + 1, subRes);
                subRes.remove(subRes.size() - 1);
            }
        }
    }

    private String toString(char[] chars, int left, int right) {
        return new String(chars, left, right - left+1);
    }

    private boolean isHuiwen(char[] chars, int left, int right) {
        if (left == right) {
            return true;
        }
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        q131 q131 = new q131();
        System.out.println(q131.partition("abacbcbab").toString());
        System.out.println(q131.partition("a").toString());
        System.out.println(q131.partition("aba").toString());
        System.out.println(q131.partition("abc").toString());
        System.out.println(q131.partition("").toString());
    }
}
