package problemSet_1;

public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int val = 0;
            for(int j = 0; j < i; j++) {
                val = val + dp[j] * dp[i-1-j];
            }
            dp[i] = val;
        }
        return dp[n];
    }


    public static void main(String[] arg) {
        System.out.println(numTrees(3));
    }
}
