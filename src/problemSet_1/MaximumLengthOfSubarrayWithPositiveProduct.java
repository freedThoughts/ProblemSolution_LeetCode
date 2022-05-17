package problemSet_1;
// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
public class MaximumLengthOfSubarrayWithPositiveProduct {

    public int getMaxLen(int[] nums) {
        int start = -1;
        int firstNegative = -1;
        int end = -1;
        int lastNegative = -1;
        int total = 0;

        int ans = 0;

        for(int i = 0; i < nums.length+1; i++) {

            if ((i == nums.length || nums[i] == 0)) {
                if (end < 0) continue;
                if (total%2 == 0) {
                    ans = Math.max(end - start +1, ans);
                } else {
                    int min = Math.min(firstNegative - start, end - lastNegative);
                    ans = Math.max(ans, end - start - min);
                }

                start = -1;
                firstNegative = -1;
                end = -1;
                lastNegative = -1;
                total = 0;

                continue;


            }
            if (start < 0) start = i;
            if (firstNegative < 0 && nums[i] < 0) firstNegative = i;
            if (nums[i] < 0) lastNegative = i;
            end = i;
            if (nums[i] < 0) total++;
        }

        return ans;
    }
}
