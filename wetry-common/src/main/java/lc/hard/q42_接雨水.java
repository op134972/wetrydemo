package lc.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-12 22:49
 * <p>
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 *
 * 转换思路：以每个i 往两边延伸。 同样的题目还有 最大矩形面积
 */
public class q42_接雨水 {

    //解法1：暴力
    public int trap(int[] height) {

        int res = 0;
        for (int i = 0; i < height.length; i++) {

            int rMax = height[i];
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > rMax) {
                    rMax = height[j];
                }
            }

            int lMax = height[i];
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > lMax) {
                    lMax = height[j];
                }
            }

            res += Math.min(lMax, rMax) - height[i];

        }

        return res;
    }

    //解法2：两个数组，左右遍历，记录i左 i右的最大值

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.99%
     * 的用户
     * 内存消耗：
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 32.04%
     * 的用户
     */
    public int trap2(int[] height) {

        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        int lMaxIndex=0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[lMaxIndex]) {
                lMaxIndex = i;
            }
            lMax[i] = lMaxIndex;
        }

        int rMaxIndex = height.length - 1;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > height[rMaxIndex]) {
                rMaxIndex = i;
            }
            rMax[i] = rMaxIndex;
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(height[lMax[i]], height[rMax[i]]) - height[i];
        }

        return res;
    }


    /**
     * 看题解
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     *
     * 总体思路：
     * 1. 当是降低的态势，就push，因为不会盛水，此时作为预备左柱。
     * 2. 当时升高的态度，就判断，因为可能会盛水，同时也要push，因为当前柱子可能最为后续的左柱。
     */
    public int trap3(int[] height) {

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer top = stack.pop();//栈顶元素作为底
                if (stack.isEmpty()) {
                    //可能空了，此时break
                    break;
                }
                Integer peekIdx = stack.peek();
                int distance = i - peekIdx - 1;
                int sHeight = Math.min(height[peekIdx], height[i]) - height[top];
                res += distance * sHeight;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        //[0,1,0,2,1,0,1,3,2,1,2,1]
        q42_接雨水 q42_接雨水 = new q42_接雨水();
        System.out.println(q42_接雨水.trap(new int[]{10, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 5}));
        System.out.println(q42_接雨水.trap2(new int[]{10, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 5}));
        System.out.println(q42_接雨水.trap3(new int[]{10, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 5}));
    }

}
