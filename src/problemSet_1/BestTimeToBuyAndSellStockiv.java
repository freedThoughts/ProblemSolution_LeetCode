package problemSet_1;

public class BestTimeToBuyAndSellStockiv {

    public static void main(String[] arg) {
        System.out.println(maxProfit(2, new int[] {2,4,1}));
    }

    public static int maxProfit(int k, int[] prices) {
        int[][] matrix = new int[k+1][prices.length];
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                int val = Math.max(matrix[i][j-1], matrix[i-1][j]);
                for(int m = 0; m < j ; m++) {
                    val = Math.max(val, prices[j] - prices[m] + matrix[i-1][m]);
                }
                matrix[i][j] = val;
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}
