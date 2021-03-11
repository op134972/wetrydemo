package lc.q4;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-24 20:50
 */
public class q169 {


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.92%
     * 的用户
     * 内存消耗：
     * 42.1 MB
     * , 在所有 Java 提交中击败了
     * 68.72%
     * 的用户
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int count = 1;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curr == nums[i]) {
                count++;
            } else if (count == 0) {
                count++;
                curr = nums[i];
            } else{
                count--;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        q169 q169 = new q169();
        System.out.println(q169.majorityElement(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7}));
        System.out.println(q169.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(q169.majorityElement(new int[]{0,0,1,1,1,2,2}));
    }
}
