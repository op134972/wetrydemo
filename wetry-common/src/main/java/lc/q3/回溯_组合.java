package lc.q3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-11 21:55
 */
public class 回溯_组合 {

    /**
     * 1.2.3.4...n 的 k个数的组合
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> comb(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();
        Set<Integer> choosed = new HashSet<>(n*2);

        backtrace(res, subRes, choosed, n, k, 1);

        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> subRes, Set<Integer> choosed, int n, int k, int index) {
        if (subRes.size() == k) {
            res.add(new ArrayList<>(subRes));
        }

        for (int i = index; i <= n; i++) {
            if (choosed.contains(i)) {
                continue;
            }
            subRes.add(i);
            int mark = subRes.size() - 1;
            choosed.add(i);
            backtrace(res, subRes, choosed, n, k, i + 1);
            subRes.remove(mark);
            choosed.remove(i);
        }
    }


    public static void main(String[] args) {
        回溯_组合 回溯_组合 = new 回溯_组合();
        List<List<Integer>> res = 回溯_组合.comb(4, 2);
        System.out.println(res.toString());
    }
}
