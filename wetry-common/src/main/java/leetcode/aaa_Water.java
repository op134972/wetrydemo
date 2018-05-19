package leetcode;

/**
 * Created by wch on 18-5-19.
 */
public class aaa_Water {

    public static void main(String[] args) {
        aaa_Water a = new aaa_Water();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(a.fun(arr));
    }

    public int fun(int[] arr) {
        return fun(arr, 0, arr.length);
    }

    public static int fun(int[] arr, int start, int end) {
        int startIndex = start;
        int sum = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] >= arr[startIndex]) {
                sum += getGapSum(arr, startIndex, i);
                startIndex = i;
            } else if (i == end - 1 && startIndex < i) {
                sum += fun(arr,startIndex+1,end);
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
