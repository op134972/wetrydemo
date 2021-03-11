package lc.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-12 22:49
 */
public class Kth {

    int count = 0;
    String res = null;

    public String kTh(String s, int k) {

        boolean[] visited = new boolean[s.length()];

        List<Character> subStr = new ArrayList<>();
        List<String> res = new ArrayList<>();

        int[] factorial = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                factorial[i] = 1;
            }else{
                factorial[i] = factorial[i - 1] * i;
            }
        }



        bt(subStr, s, k, visited, res);

        System.out.println(res.toString());

        return res.get(k);
    }

    private void bt(List<Character> subStr, String s, int k, boolean[] visited, List<String> res) {
        if (subStr.size() == s.length()) {
            res.add(subStr.toString());
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                subStr.add(s.charAt(i));
                bt(subStr, s, k, visited, res);
                visited[i] = false;
                subStr.remove(subStr.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Kth q = new Kth();
        q.kTh("abcdefg", 2);
    }
}
