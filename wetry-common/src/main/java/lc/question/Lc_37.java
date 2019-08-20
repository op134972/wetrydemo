package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-16 13:09
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc_37 {

    /**
     * 思路：
     * 1. 三个二维数组记录：每行、每列、每块是否已存在改数
     * 2. 各个位置找合适的数字填入。如果最后一字不合适，则需要回溯之前的填入数字。
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 83.30%
     * 的用户
     * 内存消耗 :
     * 35.4 MB
     * , 在所有 Java 提交中击败了
     * 71.06%
     * 的用户
     */
    public void solveSudoku(char[][] board) {
        boolean[][] rowRc = new boolean[9][9];
        boolean[][] colRc = new boolean[9][9];
        boolean[][] blockRc = new boolean[9][9];

        //第一遍 存已存在的数字
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //第i行，第j个元素
                if (board[i][j] != '.') {
                    Integer integer = Integer.valueOf(board[i][j] + "");
                    int val = integer - 1;
                    //列
                    rowRc[i][val] = true;
                    //行
                    colRc[j][val] = true;
                    //块
                    /**
                     * 2,2 -- 0 ;2,3 -- 1 ;2,5 --1 ;2,6 --2; 2,8 -- 2
                     */
                    int blockIndex = i / 3 * 3 + j / 3;
                    blockRc[blockIndex][val] = true;
                }
            }
        }

        backTrace(board, colRc, rowRc, blockRc, 0, 0);

    }

    private boolean backTrace(char[][] board, boolean[][] colRc, boolean[][] rowRc, boolean[][] blockRc, int i, int j) {
        //首先，找到空位
        while (board[i][j] != '.') {
            if (j != 8) {
                j++;
            } else {
                i++;
                j = 0;
            }
            if (i == 9) {
                return true;
            }
        }

        int blockIndex = i / 3 * 3 + j / 3;
        boolean[] rowB = rowRc[i];
        boolean[] colB = colRc[j];
        boolean[] blockB = blockRc[blockIndex];
        for (int k = 0; k < 9; k++) {
            //找到三个数据中都为false的数组，返回值，并赋值true
            if (!rowB[k] && !colB[k] && !blockB[k]) {
                rowB[k] = true;
                colB[k] = true;
                blockB[k] = true;
                board[i][j] = (char) (k + 1 + '0');
                if (backTrace(board, colRc, rowRc, blockRc, i, j)) {
                    return true;
                }else{
                    //回溯
                    rowB[k] = false;
                    colB[k] = false;
                    blockB[k] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private char getFixNum(boolean[][] rowRc, boolean[][] colRc, boolean[][] blockRc, int i, int j) {
        boolean[] rowB = rowRc[i];
        boolean[] colB = colRc[j];
        boolean[] blockB = blockRc[i / 3 * 3 + j / 3];
        //找到三个数据中都为false的数组，返回值，并赋值true
        for (int k = 0; k < 9; k++) {
            if (!rowB[k] && !colB[k] && !blockB[k]) {
                rowB[k] = true;
                colB[k] = true;
                blockB[k] = true;
                return (char) (k + 1 +'0');
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println((char) (i+'1'));
        }
    }

}
