package lc.q3;

import lc.util.ArrayUtils;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-16 18:21
 */
public class q130 {

    /*
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 97.31%
     * 的用户
     * 内存消耗：
     * 40.9 MB
     * , 在所有 Java 提交中击败了
     * 54.09%
     * 的用户
     */
    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            mark(visited, i, 0, board);
            mark(visited, i, board[0].length - 1, board);
        }

        for (int i = 0; i < board[0].length; i++) {
            mark(visited, 0, i, board);
            mark(visited, board.length - 1, i, board);
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void mark(boolean[][] visited, int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'M';
        mark(visited, i - 1, j, board);
        mark(visited, i + 1, j, board);
        mark(visited, i, j - 1, board);
        mark(visited, i, j + 1, board);
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        board[0] = new char[]{'X', 'X', 'X', 'X'};
        board[1] = new char[]{'X', 'O', 'O', 'X'};
        board[2] = new char[]{'X', 'X', 'O', 'X'};
        board[3] = new char[]{'X', 'O', 'X', 'X'};

        q130 q130 = new q130();
        q130.solve(board);
        ArrayUtils.printCharArr(board);
    }
}
