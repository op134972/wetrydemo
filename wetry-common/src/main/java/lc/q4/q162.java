package lc.q4;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-24 10:34
 */
public class q162 {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid - 1 < 0 || mid + 1 >= nums.length) {
                //返回较大
                if (nums[left] > nums[right]) {
                    return left;
                }else{
                    return right;
                }
            }
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        q162 q162 = new q162();
        int[] arr = new int[]{1,2,1,3,5,6,4};
        int res = q162.findPeakElement(arr);
        System.out.println(res);
    }
}
