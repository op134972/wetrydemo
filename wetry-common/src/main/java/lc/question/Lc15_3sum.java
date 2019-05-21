package lc.question;

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
public class Lc15_3sum {
    /**
     * 成功
     * 显示详情
     * 执行用时 : 104 ms, 在3Sum的Java提交中击败了44.97% 的用户
     * 内存消耗 : 60.2 MB, 在3Sum的Java提交中击败了7.83% 的用户
     * <p>
     * 提交时间	状态	执行用时	内存消耗	语言
     * 几秒前	通过	104 ms	60.2 MB	java
     * 2 分钟前	解答错误	N/A	N/A	java
     * 4 分钟前	解答错误	N/A	N/A	java
     * 6 分钟前	解答错误	N/A	N/A	java
     * 11 分钟前	解答错误	N/A	N/A	java
     * 15 分钟前	解答错误	N/A	N/A	java
     * 39 分钟前	超出时间限制	N/A	N/A	java
     * 14 小时前	超出时间限制	N/A	N/A	java
     * 14 小时前	超出时间限制	N/A	N/A	java
     * 14 小时前	超出时间限制	N/A	N/A	java
     * 1 天前	超出时间限制	N/A	N/A	java
     * 2 天前	解答错误	N/A	N/A	java
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                //这步很关键,如果没有，这种情况只会输出一种 -1,-1,0,1,2
                continue;
            }
            int sum = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    res.add(Arrays.asList(-sum, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > sum) {
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                } else {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                }
            }
        }

        return res;
    }
}
