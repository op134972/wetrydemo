package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-06-05 14:56
 */
public class q_33 {

    /*
     *345612
     *
     * 思路：
     * 1. 一分为二，有一边必定有序
     * 2. 判断头尾元素大小可以判断是否有序
     * 3. 判断target与头尾元素的大小可以判断target在哪边
     * 4. 如果在有序的里面，使用二分查找
     * 5. 如果在无序的那边，分解为子类问题，继续递归查找。
     */
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midVal = nums[mid];
        //一分为二，其中一个必有序
        if (midVal > nums[start]) {
            //中值大于左边，左边有序
            if (target >= nums[start] && target <= midVal) {
                //目标值存在于有序列表
                return binarySearch(nums, target, start, mid);
            }else{
                //目标值存在于无序列表
                return search(nums, target, mid, end);
            }
        } else {
            //中值大于右边，右边有序
            if (target >= nums[mid] && target <= nums[end]) {
                //目标值存在于有序列表
                return binarySearch(nums, target, mid, end);
            }else{
                //目标值存在于无序列表
                return search(nums, target, start, mid);
            }
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }
            if (midVal > target) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

}
