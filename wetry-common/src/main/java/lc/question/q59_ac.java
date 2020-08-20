package lc.question;

import lc.util.ArrayUtils;

/**
 * @Author: tangwenchuan
 * @Date: 2020-06-06 23:31
 * <p>
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class q59_ac {
    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];

        //0 右 1下 2左 3上
        int direction = 0;
        int a = 0;
        int b = 0;
        for (int i = 1; i <= n * n; i++) {
            if (direction % 4 == 0) {
                res[a][b++] = i;
                if (b == n || res[a][b] != 0) {
                    //转向
                    direction++;
                    //纠正位置
                    a++;
                    b--;
                }
            } else if (direction % 4 == 1) {
                res[a++][b] = i;
                if (a == n  || res[a][b] != 0) {
                    //转向
                    direction++;
                    //纠正位置
                    a--;
                    b--;
                }
            } else if (direction % 4 == 2) {
                res[a][b--] = i;
                if (b == -1 || res[a][b] != 0) {
                    //转向
                    direction++;
                    //纠正位置
                    a--;
                    b++;
                }
            } else if (direction % 4 == 3) {
                res[a--][b] = i;
                if (a == -1 || res[a][b] != 0) {
                    //转向
                    direction++;
                    //纠正位置
                    a++;
                    b++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new q59_ac().generateMatrix(9);
        ArrayUtils.printArr(ints);
    }
}
