package lc.q3;

import java.util.*;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-11 23:43
 *
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class q40_回溯 {

    /*
     *
     * 避免重复
     * 思路1：set去重
     * 思路2：小剪枝 candidates[i] == candidates[i - 1] 可以跳过
     *
     * 用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 55.93%
     * 的用户
     * 内存消耗：
     * 40.1 MB
     * , 在所有 Java 提交中击败了
     * 35.17%
     * 的用户
     *
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        bc(res, new ArrayList<>(), candidates, target, 0);

        return res;

    }

    private void bc(List<List<Integer>> res, ArrayList<Integer> subRes, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(subRes));
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            //去重
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int candidate = candidates[i];
            subRes.add(candidate);
            bc(res, subRes, candidates, target - candidate, i + 1);
            subRes.remove(subRes.size() - 1);
        }

    }

    public static void main(String[] args) {
        q40_回溯 q40_回溯 = new q40_回溯();
        List<List<Integer>> res = q40_回溯.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(res.toString());
    }


}
