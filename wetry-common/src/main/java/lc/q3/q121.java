package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-14 23:10
 */
public class q121 {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 1) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        q121 q121 = new q121();
        System.out.println(q121.maxProfit(arr));

    }
}
