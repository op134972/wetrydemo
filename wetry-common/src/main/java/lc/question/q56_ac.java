package lc.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-04 20:23
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路1：
 * 1. 遍历所有数组，标记区间点 至新的数组 （数组长度事先无法确定，最终等于区间最大值）
 * 2. 遍历新数组，反组成多个区间输出结果
 * 复杂度O(n)
 * 代码略
 *
 * 思路2：
 * 1. 按左端点排序
 * 2. 两两合并（贪心策略）
 * 若相交，合并继续
 * 不相交，输出前者，后者继续合并
 * 注意边界条件和初始条件。
 *
 */
public class q56_ac {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length-1; i++) {
            int l1 = intervals[i][0];
            int r1 = intervals[i][1];

            int l2 = intervals[i+1][0];
            int r2 = intervals[i+1][1];

            if (r1 < l2) {
                //不相交 前者返回
                res.add(intervals[i]);
            }else{
                //相交，合并，继续
                intervals[i + 1][0] = Math.min(l1, l2);
                intervals[i + 1][1] = Math.max(r1, r2);
            }
            if (i + 1 == intervals.length - 1) {
                res.add(intervals[i+1]);
                break;
            }
        }
        int[][] r = new int[res.size()][2];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
    }


}
