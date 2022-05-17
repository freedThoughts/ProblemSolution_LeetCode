package problemSet_1;
// https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (i < nums.length || j < nums.length) {
            while(sum < target && j < nums.length) {
                sum +=nums[j++];
            }
            if (sum < target) return ans == Integer.MAX_VALUE ? 0 :ans;
            ans = Math.min(j-i, ans);

            while(sum >= target && j > i) {
                ans = Math.min(j-i, ans);
                sum -= nums[i++];
            }
        }
        return ans;
    }
}
