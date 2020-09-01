package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-12 17:00
 * <p>
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class q79 {

    /*
     * 执行用时：
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 91.85%
     * 的用户
     * 内存消耗：
     * 42 MB
     * , 在所有 Java 提交中击败了
     * 30.42%
     * 的用户
     */
    public boolean exist(char[][] board, String word) {

        char[] chars = word.toCharArray();
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bc(board, chars, i, j, 0, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bc(char[][] board, char[] chars, int m, int n, int i, boolean[][] used) {
        //目标超界 说明之前的都满足了 返回true
        if (i == chars.length) {
            return true;
        }
        //越界
        if ((m == board.length || n == board[0].length || m < 0 || n < 0 || chars[i] != board[m][n])) {
            return false;
        }
        //已使用
        if (used[m][n]) {
            return false;
        }
        //当前相等，才继续回溯，否则，进入下一个点回溯
        used[m][n] = true;
        if (bc(board, chars, m, n + 1, i + 1, used)
                || bc(board, chars, m, n - 1, i + 1, used)
                || bc(board, chars, m + 1, n, i + 1, used)
                || bc(board, chars, m - 1, n, i + 1, used)) {
            return true;
        }
        used[m][n] = false;

        return false;
    }

    public static void main(String[] args) {
        q79 q79 = new q79();
//        char[][] board = new char[3][4];
//        board[0] = new char[]{'A', 'B', 'C', 'E'};
//        board[1] = new char[]{'S', 'F', 'C', 'S'};
//        board[2] = new char[]{'A', 'D', 'E', 'E'};
//
//        System.out.println(q79.exist(board, "ABCCED"));
//        System.out.println(q79.exist(board, "SEE"));
//        System.out.println(q79.exist(board, "SEA"));
//        System.out.println(q79.exist(board, "ABCB"));

        char[][] b = new char[1][2];
        b[0] = new char[]{'a', 'a'};
        System.out.println(q79.exist(b, "aaa"));

        char[][] b2 = new char[1][1];
        b2[0] = new char[]{'a'};
        System.out.println(q79.exist(b2, "a"));
    }


}
