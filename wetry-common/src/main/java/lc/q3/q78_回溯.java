package lc.q3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-11 15:25
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class q78_回溯 {

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.20%
     * 的用户
     * 内存消耗：
     * 40.1 MB
     * , 在所有 Java 提交中击败了
     * 45.57%
     * 的用户
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        backTrace(nums, 0, res, subList);
        return res;
    }

    private void backTrace(int[] nums, int index, List<List<Integer>> res, List<Integer> subList) {
        res.add(new ArrayList<>(subList));
        for (int i = index; i < nums.length; i++) {
            subList.add(nums[i]);
            int mark = subList.size() - 1;
            backTrace(nums, i + 1, res, subList);
            subList.remove(mark);
        }
    }

    public static void main(String[] args) {
        q78_回溯 unpaidTest = new q78_回溯();
        List<List<Integer>> subsets = unpaidTest.subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());
    }

}
