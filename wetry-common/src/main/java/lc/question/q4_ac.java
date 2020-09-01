package lc.question;

/**
 * Created by tangwc on 2019/3/7.
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class q4_ac {

    /**
     * 成功
     * 显示详情
     * 执行用时: 64 ms, 在Median of Two Sorted Arrays的Java提交中击败了70.98% 的用户
     * 内存消耗: 58.5 MB, 在Median of Two Sorted Arrays的Java提交中击败了18.92% 的用户
     */
    //对前一半排序即可
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        //奇数 中位数是一个，否则是两个
        boolean even = (l1 + l2) % 2 == 1;
        int point = (l1 + l2) / 2;

        int i = 0;
        int j = 0;
        int index = 0;

        int left = 0;
        boolean ready = false;
        while (i < l1 || j < l2) {
            int curr;
            if (i == l1) {
                curr = nums2[j++];
            } else if (j == l2) {
                curr = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                curr = nums2[j++];
            } else {
                curr = nums1[i++];
            }
            if (even) {
                if (index == point) {
                    return curr;
                }
            } else {
                if (index == point - 1 || ready) {
                    if (ready) {
                        return ((double) (left + curr)) / 2;
                    } else {
                        ready = true;
                        left = curr;
                    }
                }
            }
            index++;
        }
        return 0;
    }
}
