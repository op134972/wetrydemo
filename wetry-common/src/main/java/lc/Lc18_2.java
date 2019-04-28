package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tangwc on 2019/3/13.
 */
public class Lc18_2 {

    /**
     * 比单指针快了一倍多
     * 成功
     * 显示详情
     * 执行用时 : 118 ms, 在4Sum的Java提交中击败了19.13% 的用户
     * 内存消耗 : 45.9 MB, 在4Sum的Java提交中击败了5.68% 的用户
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum < target) {
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        l++;
                    } else {
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }


        return res;
    }


}
