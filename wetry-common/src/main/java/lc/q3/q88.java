package lc.q3;

import java.util.Arrays;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-12 22:43
 *
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class q88 {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 50.42%
     * 的用户
     *
     * 思路：归并排序，从头往前排
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int end = m + n - 1;
        int e1 = m-1;
        int e2 = n-1;
        while (e1 >= 0 || e2 >= 0) {
            if (e2 < 0) {
                break;
            }
            if (e1 < 0) {
                copy(nums2, e2, nums1, end);
                break;
            }else if (nums1[e1] > nums2[e2]) {
                nums1[end--] = nums1[e1--];
            }else{
                nums1[end--] = nums2[e2--];
            }
        }



    }

    private void copy(int[] from, int fromIndex, int[] to, int toIndex) {
        while (fromIndex >= 0) {
            to[toIndex--] = from[fromIndex--];
        }
    }

    public static void main(String[] args) {

        q88 q88 = new q88();
        int[] arr = new int[]{0};
        int[] arr2 = new int[]{1};
        q88.merge(arr, 0, arr2, 1);
        System.out.println(Arrays.toString(arr));
    }

}
