package lc.question;

import java.util.Arrays;

/**
 * Created by tangwc on 2019/3/12.
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

public class Lc16 {

    /**
     * 成功
     * 显示详情
     * 执行用时 : 25 ms, 在3Sum Closest的Java提交中击败了59.25% 的用户
     * 内存消耗 : 38.6 MB, 在3Sum Closest的Java提交中击败了0.86% 的用户
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int absGap = Integer.MAX_VALUE;
        int rg = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int gap = nums[i] + nums[l] + nums[r] - target;
                int cag = Math.abs(gap);
                if (cag > absGap) {
                    if (gap > 0) {
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        r--;
                    } else if (gap < 0) {
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        l++;
                    } else {
                        return target;
                    }
                } else if (cag < absGap) {
                    absGap = cag;
                    rg = gap;
                    if (gap > 0) {
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        r--;
                    } else if (gap < 0) {
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        l++;
                    } else {
                        return target;
                    }
                } else {
                    if (gap > 0) {

                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        r--;
                    } else if (gap < 0) {
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        l++;
                    } else {
                        return target;
                    }
                }
            }
        }
        return rg + target;
    }

    public static void main(String[] args) {

        int[] arr = {0, 5, -1, -2, 4, -1, 0, -3, 4, -5};

        System.out.println(new Lc16().threeSumClosest(arr, 1));
    }


}
