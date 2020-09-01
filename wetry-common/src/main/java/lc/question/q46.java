package lc.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-18 19:47
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q46 {

    /**
     * 思路：
     * 回溯法
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 18.31%
     * 的用户
     * 内存消耗 :
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 49.03%
     * 的用户
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        boolean[] arr = new boolean[nums.length];

        backTrace(res, stack, arr, nums);

        return res;
    }

    private void backTrace(List<List<Integer>> res, Stack<Integer> stack, boolean[] arr, int[] nums) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!arr[i]) {
                stack.push(nums[i]);
                arr[i] = true;
                backTrace(res, stack, arr, nums);
                stack.pop();
                arr[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        List<List<Integer>> res = new q46().permute(arr);
        System.out.println(res.toString());

    }
}
