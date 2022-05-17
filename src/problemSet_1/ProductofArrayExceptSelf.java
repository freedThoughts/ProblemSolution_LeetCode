package problemSet_1;
// https://leetcode.com/problems/product-of-array-except-self/
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int indexForZero = -1;
        int product = 1;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (indexForZero >=0) return ans;
                indexForZero = i;
                continue;
            }

            product = product * nums[i];
        }

        if (indexForZero >=0) {
            ans[indexForZero] = product;
            return ans;
        }

        for(int i = 0; i < nums.length; i++) {
            ans[i] = product / nums[i];
        }

        return ans;

    }
}
