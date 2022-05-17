package problemSet_1;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] arg) {
        System.out.println(maxProfit(new int[] {1,2,4}));
    }

    public static int maxProfit(int[] prices) {
        Integer[][] dayValueMatrix = new Integer[2][prices.length];
        return dfs(prices, 0, dayValueMatrix, 0);
    }

    static int dfs(int[] prices, int dayIndex, Integer[][] dayValueMatrix, int isBuying) {
        if (dayIndex >= prices.length) return 0;
        if (dayValueMatrix[isBuying][dayIndex] != null) return dayValueMatrix[isBuying][dayIndex];

        if (isBuying == 0) {
            int dayValue = dfs(prices, dayIndex+1, dayValueMatrix, 1) - prices[dayIndex];
            int coolDownVal = dfs(prices, dayIndex+1, dayValueMatrix, 0);
            dayValueMatrix[isBuying][dayIndex] = Math.max(dayValue, coolDownVal);
            return dayValueMatrix[isBuying][dayIndex];
        }

        int dayValue = dfs(prices, dayIndex+2, dayValueMatrix, 0) + prices[dayIndex];
        int coolDownVal = dfs(prices, dayIndex+1, dayValueMatrix, 0);
        dayValueMatrix[isBuying][dayIndex] = Math.max(dayValue, coolDownVal);
        return dayValueMatrix[isBuying][dayIndex];
    }
}
