package lc.q3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-11 23:23
 * <p>
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class q39_回溯 {


    /*
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 42.20%
     * 的用户
     * 内存消耗：
     * 40 MB
     * , 在所有 Java 提交中击败了
     * 61.90%
     * 的用户
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();

        backTrace(candidates, res, subRes, 0, target, 0);

        return res;
    }

    private void backTrace(int[] candidates, //数组
                           List<List<Integer>> res,//总结果
                           List<Integer> subRes, //子结果
                           int sum, //子结果中元素总和
                           int target, //目标结果和
                           int index//下标，防止倒流 不+1 因为需要使用元素
    ) {
        if (sum == target) {
            res.add(new ArrayList<>(subRes));
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            subRes.add(candidate);
            int mark = subRes.size() - 1;
            backTrace(candidates, res, subRes, sum + candidate, target, i);
            subRes.remove(mark);
        }
    }

    public static void main(String[] args) {
        q39_回溯 q39_回溯 = new q39_回溯();
        int[] arr = new int[]{2, 3, 5};
        List<List<Integer>> res = q39_回溯.combinationSum(arr, 8);
        System.out.println(res.toString());
    }
}
