package lc.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-18 23:16
 */
public class q128_最长连续序列 {


    /*
     * 执行用时：
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 49.48%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 77.94%
     * 的用户
     */
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int max = 0;
        for (Integer num : numSet) {
            //只有断点才会判断，因为每个while循环会一直往下找
            if (!numSet.contains(num - 1)) {//这个判断很重要，避免了重复计算。加之前 超过5% 加之后超过49%
                int currLength = 1;
                while (numSet.contains(num + 1)) {
                    //一直往后加
                    currLength++;
                    num++;
                }
                max = Math.max(currLength, max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        q128_最长连续序列 q128 = new q128_最长连续序列();
        System.out.println(q128.longestConsecutive(new int[]{}));
    }
}
