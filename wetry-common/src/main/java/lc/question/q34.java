package lc.question;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-10 15:20
 * <p>
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q34 {

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 43.4 MB
     * , 在所有 Java 提交中击败了
     * 5.06%
     * 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        int res1 = seachIndex(nums, target, true);
        int res2 = seachIndex(nums, target, false);
        return new int[]{res1, res2};
    }

    private int seachIndex(int[] nums, int target, boolean left) {

        int start = 0;
        int end = nums.length - 1;
        int mid;
        int index = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            int val = nums[mid];
            if (val == target) {
                index = mid;
                if (left) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (val > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        q34 q34 = new q34();
        System.out.println(Arrays.toString(q34.searchRange(arr, 8)));
        System.out.println(Arrays.toString(q34.searchRange(arr, 6)));
    }
}
