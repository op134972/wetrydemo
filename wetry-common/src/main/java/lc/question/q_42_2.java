package lc.question;

/**
 * @Author: tangwenchuan
 * @Date: 2019-08-19 21:40
 */
public class q_42_2 {


    /**
     * 思路1：
     *
     */
    public int fun(int[] arr){
        // 0,1,0,2,1,0,1,3,2,1,2,1
        //向左找，最大元素的下标
        int[] leftMax = new int[arr.length];
        //向右找，最大元素的下标
        int[] rightMax = new int[arr.length];

        //使用二维数组记录最大值搜寻结果，dp[i][j]表示第i个元素，右侧

        for (int i = 0,j=arr.length-1; i < arr.length && j>=0; i++,j--) {
            if (i > 0 && rightMax[i - 1] >= i) {
                rightMax[i] = rightMax[i - 1];
            }else{
                rightMax[i] = rightMax(arr, i);
            }

            if (j < arr.length - 1 && leftMax[j+1] <= j) {
                leftMax[j] = leftMax[j+1];
            }else{
                leftMax[j] = leftMax(arr, j);
            }
        }

        return getSum(leftMax, rightMax, arr);
    }

    private int getSum(int[] leftMax, int[] rightMax, int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(arr[leftMax[i]], arr[rightMax[i]]) - arr[i];
        }
        return sum;
    }

    private int leftMax(int[] arr, int j) {
        int res = j;
        for (int i = j; i >= 0; i--) {
            if (arr[i] > arr[res]) {
                res = i;
            }
        }
        return res;
    }

    private int rightMax(int[] arr, int i) {
        int res = i;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] > arr[res]) {
                res = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new q_42_2().fun(arr));
    }
}
