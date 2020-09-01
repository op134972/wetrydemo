package lc.question;

import java.util.*;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-18 11:53
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q40 {

    /**
     * 回溯法，关键在于排除重复的情况
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 90.06%
     * 的用户
     * 内存消耗 :
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 85.50%
     * 的用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        //必须排序
        Arrays.sort(candidates);

        Stack<Integer> stack = new Stack<>();

        backTrace(res, stack, candidates, target, 0);

        return res;
    }

    private void backTrace(List<List<Integer>> res, Stack<Integer> stack, int[] candidates, int target, int k) {
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        if (k == candidates.length - 1 || candidates[k] > target) {
            return;
        }
        for (int i = k; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            //这里只是将for循环第二次及以上相同的元素排除掉，并没有排除递归的第一个
            if (i > k && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.push(candidates[i]);
            backTrace(res, stack, candidates, target - candidates[i], i + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        // 1,1,2,5,6,7,10
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = new q40().combinationSum2(arr, 8);
        System.out.println(lists);
    }

}
