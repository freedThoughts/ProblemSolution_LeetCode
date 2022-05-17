package problemSet_1;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/
public class BestTimeToBuyAndSellStockiii {

    public int maxProfit(int[] prices) {

        int[] profit = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            profit[i] = Math.max(profit[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        int[] profit2 = new int[prices.length];
        int max = prices[prices.length-1];

        int ans = 0;

        for(int i = prices.length-2; i >= 0; i--) {
            profit2[i] = Math.max(profit2[i+1], max - prices[i]);
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, profit[i] + profit2[i]);
        }

        return ans;
    }
}
