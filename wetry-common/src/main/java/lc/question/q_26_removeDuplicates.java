package lc.question;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2019-05-20 18:08
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class q_26_removeDuplicates {


    /**
     * 1. 排序数组
     * 2. 不能用额外的空间
     * 3. 不需要管size之后元素
     *
     * 成功
     * 显示详情
     * 执行用时 : 2 ms, 在Remove Duplicates from Sorted Array的Java提交中击败了98.74% 的用户
     * 内存消耗 : 43 MB, 在Remove Duplicates from Sorted Array的Java提交中击败了79.00% 的
     */
    public int removeDuplicates(int[] nums) {

        int index = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                pre = nums[i];
                nums[index++] = pre;
                continue;
            }
            int num = nums[i];
            if (num != pre) {
                nums[index++] = num;
                pre = num;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,6,6,9,9,9};
        int i = new q_26_removeDuplicates().removeDuplicates(arr);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }
}
