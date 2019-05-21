package lc.question;

/**
 * Created by tangwc on 2019/3/8.
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Lc11 {


    /**
     * 1. 暴力法   n^2
     * 2. 双指针  谁小谁动
     * <p>
     * 成功
     * 显示详情
     * 执行用时: 11 ms, 在Container With Most Water的Java提交中击败了46.23% 的用户
     * 内存消耗: 44.1 MB, 在Container With Most Water的Java提交中击败了0.96% 的用户
     */
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int area = 0;
        int i = 0, j = height.length - 1;
        try {
            while (i <= j && i < height.length && j >= 0) {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
                // 关键  两个指针,谁小谁动
                if (height[j] > height[i]) {
                    i++;
                } else if (height[i] > height[j]) {
                    j--;
                } else {
                    j--;
                }
            }
        } catch (Exception e) {
            return area;
        }
        return area;
    }

    public static void main(String[] args) {
        int[] aa = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] aaa = {1, 3, 2, 5, 25, 24, 5};
        System.out.println(new Lc11().maxArea(aa));
        System.out.println(new Lc11().maxArea(aaa));
    }


}
