package lc.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tangwc on 2019/3/13.
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Lc18 {

    /**
     * 成功
     * 显示详情
     * 执行用时 : 564 ms, 在4Sum的Java提交中击败了4.63% 的用户
     * 内存消耗 : 54.4 MB, 在4Sum的Java提交中击败了3.19% 的用户
     *
     *
     * 这种思路抽象出来是单指针的做法，结合之前3sum问题，4sum只不过是3sum外层再套一层循环，因此可以 使用双指针的解法，见解法2
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                /**
                 * 为什么这样就可以防止重复了？
                 * 保证每个位置的数字只出现一次，比如此位是1，下一位也是1，
                 * 因为是高位，后三位已经涵盖了第二次为1的各种情况，因此每
                 * 一位出现的数字只能出现一次。后三位同理。
                 */
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k != j + 1 && nums[k - 1] == nums[k]) {
                        continue;
                    }
                    for (int l = k + 1; l < nums.length; l++) {
                        if (l != k + 1 && nums[l - 1] == nums[l]) {
                            continue;
                        }
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        } else if (sum > target) {
                            break;
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(new Lc18().fourSum(arr, 0));
        System.out.println(new Lc18_2().fourSum(arr, 0));
    }

}
