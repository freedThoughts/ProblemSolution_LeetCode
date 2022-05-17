package problemSet_1;

// https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // >= condition is required for same number repeation like  {2, 2, 2}
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i < 0) {
            reverse (nums, 0, nums.length-1);
            return;
        }
        int j = nums.length-1;
        // Condition <= os required for same nuber repeation like {1, 5, 1}
        while (nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i+1, nums.length-1);
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    private void reverse(int[] nums, int m, int n) {
        while (m < n) {
            swap(nums, m, n);
            m++;
            n--;
        }
    }
}
