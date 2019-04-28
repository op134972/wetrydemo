package lc;

import java.util.*;

/**
 * Created by tangwc on 2019/3/11.
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Lc15_3sum超时 {

    /**
     * 311 / 313 个通过测试用例
     * 状态：超出时间限制
     * 提交时间：0 分钟之前
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        int[][] dp = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = nums[i] + nums[j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> numset = new HashSet<>();
        for (int num : nums) {
            numset.add(num);
        }

        Set<String> sumSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int d = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (sumSet.contains(nums[i] + ":" + nums[j])) {
                    //去重
                    continue;
                } else {
                    sumSet.add(nums[i] + ":" + nums[j]);
                }
                //二分查找是否有c == -(a+b)  会超时，直接用set试一下
                if (numset.contains(-dp[i][j])) {
                    int c = contains(nums, -dp[i][j], j + 1, Math.min(nums.length - 1, d));
                    if (c != -1) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[c]);
                        d = c;
                        res.add(l);
                    }
                }
            }
        }
        return res;
    }

    private int contains(int[] nums, int target, int start, int end) {
        if (start > nums.length - 1 || end > nums.length - 1) {
            return -1;
        }
        if (nums[start] > target || nums[end] < target) {
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 1. 1,2,3,4,5,6，7,8
     * 以 a+b=c，c为基点进行移动。a从头开始，b从尾部开始。因为避免重复的，前后等值则移动，要动一起动
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过可能重复的答案
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;   // 跳过重复值
                        }
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return ls;
    }
}
