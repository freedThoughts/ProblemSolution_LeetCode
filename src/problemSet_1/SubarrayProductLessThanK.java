package problemSet_1;


// https://leetcode.com/problems/subarray-product-less-than-k/submissions/
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int count) {
        int ans = 0;
        int product = 1;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while(right >= left && product >= count)
                product = product / nums[left++];
            if (left > right) continue;
            ans += right-left+1;
        }
        return ans;
    }
}
