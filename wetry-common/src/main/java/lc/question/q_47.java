package lc.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-18 20:17
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class q_47 {


    /**
     * 思路：
     * 1. 回溯法
     * 2. 重点排除重复排列，!visited[i-1]那里是关键
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 84.45%
     * 的用户
     * 内存消耗 :
     * 43.6 MB
     * , 在所有 Java 提交中击败了
     * 65.71%
     * 的用户
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        backTrace(res, temp, nums, visited);

        return res;
    }

    private void backTrace(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            //visited[i-1]表示之前这个元素还没使用过
            /**
             * 存在重复分支的情况：
             * 1，1，2
             * 选取第二个1作为排列的第一个元素的时候，会和选取第一个1的情况重复。需要甄别出这种情况不一样的状态，进行筛选。即 visited[i-1] = false。
             * 因为如果是确定选取第一个 1作为排列的头元素时，这个时候第二个1应该被选取，这时 visited[i-1] = true。因此条件是 !visited[i-1] && i != 0 && nums[i-1] == nums[i]
             */
            if (i != 0  && nums[i] == nums[i - 1] && !visited[i-1]) {
                continue;
            }

            temp.add(nums[i]);
            visited[i] = true;
            backTrace(res, temp, nums, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(new q_47().permuteUnique(arr).toString());
    }

}
