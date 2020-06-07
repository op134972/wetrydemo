package lc.question;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2019-05-20 18:26
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class q_27_removeElement {


    /**
     * 成功
     * 显示详情
     * 执行用时 : 1 ms, 在Remove Element的Java提交中击败了99.63% 的用户
     * 内存消耗 : 34.6 MB, 在Remove Element的Java提交中击败了94.76% 的用户
     */
    public int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != val) {
                nums[index++] = num;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        new q_27_removeElement().removeElement(arr, 3);
        System.out.println(Arrays.toString(arr));

    }
}
