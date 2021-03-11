package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-06-05 14:56
 * <p>
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class q33 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        /**
         * 思路：找两次，第一次找转折点。
         * 找到转折点之后，可以判断target在哪个区间，再根据二分法找
         */

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            //提前返回
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            }
            if (nums[mid] > nums[left]) {
                //转折点在右边
                left = mid;
            } else {
                right = mid;
            }
        }
        int pivot = left;

        /**
         * 到这里，至少能保证 [0,pivot][pivot+1,end]两个区间是有序的，剩下的就好说了，二分查找
         */
        if (nums[pivot] == target) {
            return pivot;
        } else if (nums[pivot] > target && nums[0] <= target) {
            return find(nums, 0, pivot, target);
        } else {
            return find(nums, pivot + 1, nums.length - 1, target);
        }
    }

    private int find(int[] nums, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {
                //转折点在右边
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        q33 q33 = new q33();
        int[] arr = {4, 5, 6, 7, 0, 1, 2,3};
        System.out.println(q33.search(arr, 2));
        System.out.println(q33.search(arr, 0));
        System.out.println(q33.search(arr, 7));

        int[] arr2=  {0,1,2,3,4,5,6,7};
        System.out.println(q33.search(arr2, 7));
        int[] arr3=  {0};
        System.out.println(q33.search(arr3, 0));

    }

}
