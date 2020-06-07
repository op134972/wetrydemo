package lc.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-17 22:51
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q_39 {

    /**
     * 思路：
     * 1. 分解成子问题  【2，3，5】 10可以分解成：
     * 【2，3，5】8
     *
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 28 ms
     * , 在所有 Java 提交中击败了
     * 17.25%
     * 的用户
     * 内存消耗 :
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 79.24%
     * 的用户
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        //必须排序
        Arrays.sort(candidates);

        Stack<Integer> stack = new Stack<>();

        backTrace(res, stack, candidates, target,0);

        return res;
    }

    private void backTrace(List<List<Integer>> res, Stack<Integer> stack, int[] candidates, int target, int k) {
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (candidates[0] > target) {
            return ;
        }
        for (int i = k; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            stack.push(candidates[i]);
            backTrace(res, stack, candidates, target - candidates[i], i);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        List<List<Integer>> lists = new q_39().combinationSum(arr, 10);
        System.out.println(lists);
    }

}
