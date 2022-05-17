package problemSet_1;

import java.util.Arrays;
// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0, j = 0;
        while(i < nums.length && j < nums.length){
            int sum = 0;
            while(i < nums.length && nums[i] - nums[j] < k){
                i++;
            }

            while(i < nums.length && j < nums.length && nums[i] - nums[j] >= k){
                if (nums[i] - nums[j] == k)
                    sum++;
                j++;
            }

            int val = sum;
            while(i < nums.length-1 && nums[i] == nums[i+1]){
                val = val+ sum;
                i++;
            }
            count = count + val;
        }

        return count;
    }
}
