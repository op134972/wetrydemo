package lc.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-12 21:26
 * <p>
 * 矩形最大面积
 * <p>
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class q84_矩形面积 {

    //解法1：暴力
    /**
     * 执行用时：
     * 1268 ms
     * , 在所有 Java 提交中击败了
     * 5.08%
     * 的用户
     * 内存消耗：
     * 40.9 MB
     * , 在所有 Java 提交中击败了
     * 5.02%
     * 的用户
     */
    public int largestRectangleArea(int[] heights) {

        int res = 0;
        for (int i = 0; i < heights.length; i++) {

            int lArea = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    lArea = (i - j - 1) * heights[i];
                    break;
                }
                lArea = (i - j) * heights[i];
            }

            int rArea = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    rArea = (j - i - 1) * heights[i];
                    break;
                }
                rArea = (j - i) * heights[i];
            }

            res = Math.max(res, (lArea + rArea + heights[i]));
        }
        return res;
    }

    //解法2：栈优化

    /**
     * 执行用时：
     * 14 ms
     * , 在所有 Java 提交中击败了
     * 47.67%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 96.62%
     * 的用户
     */
    public int largestRectangleArea2(int[] heights) {

        //stack里面存的是下标！！！！！！！
        //从左到右遍历，int[i]表示 i左边，小于height[i]的最近的坐标，若没有则为-1
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];


        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                left[i] = -1;
            }else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                right[i] = heights.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < left.length; i++) {
            res = Math.max((right[i] - left[i] - 1) * heights[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        q84_矩形面积 q84_矩形面积 = new q84_矩形面积();
        System.out.println(q84_矩形面积.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(q84_矩形面积.largestRectangleArea(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(q84_矩形面积.largestRectangleArea(new int[]{1}));
        System.out.println(q84_矩形面积.largestRectangleArea(new int[]{1, 1}));


        System.out.println(q84_矩形面积.largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(q84_矩形面积.largestRectangleArea2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(q84_矩形面积.largestRectangleArea2(new int[]{1}));
        System.out.println(q84_矩形面积.largestRectangleArea2(new int[]{1, 1}));
        System.out.println(q84_矩形面积.largestRectangleArea2(new int[]{3,2,3}));
//        6,7,5,2,4,5,9,3
        //-1,0,


        Deque<Integer> stack = new ArrayDeque<>();


        Queue<Integer> queue = new LinkedBlockingQueue<>();
    }

}
