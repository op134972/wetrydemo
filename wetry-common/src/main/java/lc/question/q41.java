package lc.question;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-18 22:22
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class q41 {

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 87.81%
     * 的用户
     * 内存消耗：
     * 37.4 MB
     * , 在所有 Java 提交中击败了
     * 94.95%
     * 的用户
     */
    public int firstMissingPositive(int[] nums) {

        int res = 1;
        Set<Integer> set = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val == res) {
                set.add(val);
                res = getNext(res,set);
            }else if (val > res) {
                //记录大于的数已经出现过
                set.add(val);
            }
        }

        return res;

    }

    private int getNext(int res, Set<Integer> set) {
        do {
            res++;
        } while (set.contains(res));
        return res;
    }

    public static void main(String[] args) {
        q41 q41 = new q41();
        System.out.println(q41.firstMissingPositive(new int[]{2,1}));
        System.out.println(q41.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(q41.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(q41.firstMissingPositive(new int[]{7,8,9,11,12}));
    }

}
