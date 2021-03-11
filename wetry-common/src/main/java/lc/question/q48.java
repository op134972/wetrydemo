package lc.question;

import lc.util.ArrayUtils;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-17 09:28
 */
public class q48 {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 11.08%
     * 的用户
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean[][] modified = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int m = i;
                int n = j;
                int pre = matrix[m][n];
                int temp;
                while (!modified[m][n]) {
                    modified[m][n] = true;
                    int x = matrix.length - m - 1;
                    int y = matrix[0].length - n - 1;
                    m = n;
                    n = x;

                    temp = matrix[m][n];
                    matrix[m][n] = pre;
                    pre = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        q48 q48 = new q48();
        int[][] arrs = new int[4][4];
        arrs[0] = new int[]{1,2,3,4};
        arrs[1] = new int[]{5,6,7,8};
        arrs[2] = new int[]{9,10,11,12};
        arrs[3] = new int[]{13,14,15,16};

        q48.rotate(arrs);

        ArrayUtils.printArr(arrs);

    }
}
