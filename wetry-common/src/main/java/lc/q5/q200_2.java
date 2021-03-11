package lc.q5;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-25 23:10
 */
public class q200_2 {

    /*
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 97.62%
     * 的用户
     * 内存消耗：
     * 42.5 MB
     * , 在所有 Java 提交中击败了
     * 20.99%
     * 的用户
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1') {
                    res++;
                    link(grid, i, j);
                }
            }
        }

        return res;
    }

    /**
     * 链接当前点所有的岛屿 遍历的过设置为2
     */
    private void link(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j]='2';
        link(grid, i + 1, j);
        link(grid, i - 1, j);
        link(grid, i, j + 1);
        link(grid, i, j - 1);
    }
}
