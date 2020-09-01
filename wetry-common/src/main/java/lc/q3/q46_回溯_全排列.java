package lc.q3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-11 21:45
 */
public class q46_回溯_全排列 {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();
        Set<Integer> choosed = new HashSet<>(nums.length * 2);

        backTrace(nums,  res, subRes,choosed);

        return res;
    }

    private void backTrace(int[] arr, List<List<Integer>> res, List<Integer> subRes, Set<Integer> choosed) {
        if (subRes.size() == arr.length) {
            res.add(new ArrayList<>(subRes));
        }

        for (int i = 0; i < arr.length; i++) {
            if (choosed.contains(arr[i])) {
                continue;
            }
            int val = arr[i];
            subRes.add(val);
            choosed.add(val);
            int mark = subRes.size() - 1;
            backTrace(arr, res, subRes, choosed);
            subRes.remove(mark);
            choosed.remove(val);
        }
    }

    public static void main(String[] args) {
        q46_回溯_全排列 q46_回溯_全排列 = new q46_回溯_全排列();
        List<List<Integer>> all = q46_回溯_全排列.permute(new int[]{1, 2, 3,4,5,6,7,8});
        System.out.println(all.size());
    }
}
