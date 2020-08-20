package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-15 10:35
 */
public class q122 {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.52%
     * 的用户
     * 内存消耗：
     * 39.7 MB
     * , 在所有 Java 提交中击败了
     * 58.26%
     * 的用户
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 1) {
            return 0;
        }

        int sum = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length && left < prices.length) {
            //找最低买点
            while (left + 1 < prices.length && prices[left + 1] <= prices[left]) {
                left++;
            }
            right = left + 1;
            //找最佳卖点
            while (right + 1 < prices.length && prices[right + 1] >= prices[right]) {
                right++;
            }
            if (left < right && right < prices.length) {
                sum += Math.max(0, prices[right] - prices[left]);
            }
            left = right + 1;
        }

        return sum;
    }

}
