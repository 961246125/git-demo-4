package example.LeetCode;

/**
 * 买卖股票（简单）
 */
public class Leetcode121 {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            result = Math.max(result, prices[i] - minPrice);
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode121 leetcode121 = new Leetcode121();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(leetcode121.maxProfit(prices));
    }
}
