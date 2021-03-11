package lc.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-12 22:49
 */
public class 全排列 {

    int count = 0;
    String res = null;

    public String fullPer(String s, int k) {

        boolean[] visited = new boolean[s.length()];

        List<Character> subStr = new ArrayList<>();
        List<String> res = new ArrayList<>();

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
        全排列 q = new 全排列();
        q.fullPer("abcdefg", 2);
    }
}
