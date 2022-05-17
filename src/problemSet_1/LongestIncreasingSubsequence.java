package problemSet_1;
// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    public static void main(String[] arg) {
        System.out.println(lengthOfLIS(new int[]{
                10,9,2,5,3,7,101,18
        }));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] ans = new int[nums.length];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, ans[j]);
                }
            }

            ans[i] = max+1;
            result = Math.max(result, ans[i]);
        }

        return result;

    }
}
