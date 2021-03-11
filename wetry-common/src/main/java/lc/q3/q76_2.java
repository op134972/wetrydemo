package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-24 18:05
 */
public class q76_2 {

    /**
     * S = "ADOBECODEBANC", T = "ABC"
     * "BANC"
     */
    public String minWindow(String s, String t) {

        int[] p = new int[256];
        int[] c = new int[256];

        char[] tArr = t.toCharArray();

        for (char cr : tArr) {
            p[index(cr)]++;
        }

        int count = 0;

        int l = 0;
        int r = 0;

        int length = s.length() + 1;
        String res = "";

        while (l <= r) {

            while (r < s.length() && count < t.length()) {
                int i = index(s.charAt(r));
                if (p[i] > 0) {
                    if (c[i]<p[i]) {
                        count++;
                    }
                    c[i]++;
                }
                r++;
            }

            if (count < t.length()) {
                break;
            }

            while (l < r) {
                int i = index(s.charAt(l));
                if (p[i] > 0) {
                    if (count == t.length()) {
                        String substring = s.substring(l, r);
                        if (substring.length()<length) {
                            length = substring.length();
                            res = substring;
                        }
                    }
                    if (c[i] <= p[i]) {
                        count--;
                    }
                    c[i]--;
                    l++;
                    break;
                }
                l++;
            }
        }
        return res;
    }

    private int index(char c) {
        int i = c - 'A';
        return i;
    }

    public static void main(String[] args) {
        q76_2 q76_2 = new q76_2();
        System.out.println(q76_2.minWindow("ADOBECODEBANC", "ODC"));

    }
}
