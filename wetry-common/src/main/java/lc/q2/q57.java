package lc.q2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-06 22:30
 *
 * 各种边界条件 ，，，哥们放弃了
 */
public class q57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean merged = false;
        List<int[]> res = new ArrayList<>(intervals.length + 1);

        if (intervals.length == 0) {
            res.add(newInterval);
        }

        if (intervals.length == 1) {
            int l1 = intervals[0][0];
            int r1 = intervals[0][1];
            if (newInterval[1] < l1) {
                res.add(newInterval);
                addAll(0, intervals, res);
            }else if (r1 < newInterval[0]) {
                res.add(intervals[0]);
                res.add(newInterval);
            } else {
                intervals[0][0] = Math.min(Math.min(l1, newInterval[0]), Math.min(r1, newInterval[1]));
                intervals[0][1] = Math.max(Math.max(r1, newInterval[1]), Math.max(l1, newInterval[0]));
                res.add(intervals[0]);
            }
        }

        for (int i = 0; i < intervals.length - 1; i++) {
            int l1 = intervals[i][0];
            int r1 = intervals[i][1];
            if (!merged) {
                //没有合并，和newInterval比较
                if (newInterval[1] < l1) {
                    res.add(newInterval);
                    addAll(i, intervals, res);
                    break;
                }
                if (r1 < newInterval[0]) {
                    res.add(intervals[i]);
                } else {
                    intervals[i][0] = Math.min(Math.min(l1, newInterval[0]), Math.min(r1, newInterval[1]));
                    intervals[i][1] = Math.max(Math.max(r1, newInterval[1]), Math.max(l1, newInterval[0]));
                    merged = true;
                    i--;
                }
            } else {
                //合并了，需要两两合并
                int l2 = intervals[i + 1][0];
                int r2 = intervals[i + 1][1];

                if (r1 < l2) {
                    //不相交 前者返回
                    res.add(intervals[i]);
                } else {
                    //相交，合并，继续
                    intervals[i + 1][0] = Math.min(l1, l2);
                    intervals[i + 1][1] = Math.max(r1, r2);
                }
                if (i + 1 == intervals.length - 1) {
                    res.add(intervals[i + 1]);
                    if (!merged) {
                        res.add(newInterval);
                    }
                    break;
                }
            }
        }

        int[][] r = new int[res.size()][2];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    private void addAll(int i, int[][] intervals, List<int[]> res) {
        for (int j = i; j <intervals.length ; j++) {
            res.add(intervals[i]);
        }
    }
}
