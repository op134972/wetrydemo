package lc.question;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2019-05-21 11:33
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 123 → 132
 * 321 → 123
 * 115 → 151
 * 13222  21223
 * 14652    21456
 * 230241  230412
 * 15432 21345
 */
public class q31 {


    /**
     * 成功
     * 显示详情
     * 执行用时 : 3 ms, 在Next Permutation的Java提交中击败了68.74% 的用户
     * 内存消耗 : 36.5 MB, 在Next Permutation的Java提交中击败了89.88% 的用户
     */
    public void nextPermutation(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {
            //从后往前找大于当前位的最小元素下标返回(第一次出现的下标)
            int lessIndex = findSecondBiggerElement(i, nums);
            if (lessIndex != -1) {
                //如果有，交换，并将后面的元素小序排列
                exchangeEle(i, lessIndex, nums);
                subSort(nums, i);
                return;
            }
        }
        //没有说明原始序列是降序，全部翻转
        reverseArr(nums);
    }

    private int findSecondBiggerElement(int startIndex, int[] nums) {
        if (startIndex == nums.length - 1) {
            return -1;
        }
        int secondBig = Integer.MAX_VALUE;
        int res = -1;
        for (int i = startIndex+1; i < nums.length; i++) {
            if (nums[i] < secondBig && nums[i] > nums[startIndex]) {
                secondBig = nums[i];
                res = i;
            }
        }
        return res;
    }

    private void subSort(int[] nums, int endIndex) {
        for (int i = nums.length-1; i > endIndex ; i--) {
            for (int j = i-1; j > endIndex ; j--) {
                if (nums[j] > nums[i]) {
                    exchangeEle(i, j, nums);
                }
            }
        }
    }

    private void reverseArr(int[] nums) {
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            exchangeEle(i, j, nums);
        }
    }

    private void exchangeEle(int i1, int i2, int[] nums) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        List<String> tests = Arrays.asList("1,2,3","3,2,1","1,5,4,3,2","1,3,2,2,2","1,2,5","5,2,1,6,3","1,1,2,3,1,2,5","1,1,1,3,3,3");
        int[][] arrs = new int[100][];
        for (int i = 0; i < tests.size(); i++) {
            String s = tests.get(i);
            String[] split = StringUtils.split(s, ",");
            arrs[i] = transFroMStr(split);
        }

        for (int[] arr : arrs) {

            System.out.print("before:" + Arrays.toString(arr));
            q31 obj = new q31();
            obj.nextPermutation(arr);

            System.out.println("after:"+Arrays.toString(arr));

        }
    }

    private static int[] transFroMStr(String[] split) {
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Integer.valueOf(split[i]);
        }
        return res;
    }

}
