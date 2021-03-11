package lc.q5;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-25 23:10
 */
public class q200 {

    /*
     * 执行用时：
     * 33 ms
     * , 在所有 Java 提交中击败了
     * 6.02%
     * 的用户
     * 内存消耗：
     * 43.5 MB
     * , 在所有 Java 提交中击败了
     * 5.02%
     * 的用户
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1' && !set.contains(i + "_" + j)) {
                    res++;
                    link(grid, i, j, set);
                }
            }
        }

        return res;
    }

    /**
     * 链接当前点所有的岛屿 加入set
     */
    private void link(char[][] grid, int i, int j, Set<String> set) {
        if (set.contains(i + "_" + j)) {
            return;
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        set.add(i + "_" + j);
        link(grid, i + 1, j, set);
        link(grid, i - 1, j, set);
        link(grid, i, j + 1, set);
        link(grid, i, j - 1, set);
    }
}
