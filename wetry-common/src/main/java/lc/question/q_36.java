package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-14 23:53
 * <p>
 * 有效的数独
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class q_36 {


    /**
     * 思路：
     * 1. 使用3个boolean[9][9]的数据维护记录，i表示行、列、3*3块，j表示对应的数字是否已经出现
     * 2. 也可使用set来记录，复杂度也为O(1)，空间复杂度略高。
     *
     *
     * 结果：
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 55.09%
     * 的用户
     * 内存消耗 :
     * 40.3 MB
     * , 在所有 Java 提交中击败了
     * 90.45%
     * 的用户
     */
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rowRc = new boolean[9][9];
        boolean[][] colRc = new boolean[9][9];
        boolean[][] blockRc = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //第i行，第j个元素
                if (board[i][j] != '.') {
                    Integer integer = Integer.valueOf(board[i][j] + "");
                    int val = integer-1;
                    //列
                    if (rowRc[i][val]) {
                        return false;
                    }else{
                        rowRc[i][val] = true;
                    }
                    //行
                    if (colRc[j][val]) {
                        return false;
                    }else{
                        colRc[j][val] = true;
                    }
                    //块
                    /**
                     * 2,2 -- 0 ;2,3 -- 1 ;2,5 --1 ;2,6 --2; 2,8 -- 2
                     */
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (blockRc[blockIndex][val]) {
                        return false;
                    }else{
                        blockRc[blockIndex][val] = true;
                    }
                }
            }
        }

        return true;
    }

}
