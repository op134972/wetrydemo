package leetcode;

/**
 * Created by wch on 18-5-19.
 */
public class aaa_Water {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(fun(arr));
    }

    public static int fun(int[] arr) {
        int startIndex = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr[startIndex]) {
                sum += getGapSum(arr, startIndex, i);
                startIndex = i;
            }
        }
        return sum;
    }

    private static int getGapSum(int[] arr, int startIndex, int endIndex) {
        int compare = arr[startIndex];
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            int dis = compare - arr[i];
            dis = (dis > 0 ? dis : 0);
            sum += dis;
        }
        return sum;
    }

}
