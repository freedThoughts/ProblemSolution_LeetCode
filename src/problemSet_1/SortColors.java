package problemSet_1;

// https://leetcode.com/problems/sort-colors/submissions/
public class SortColors {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length-1;

        for (int i = 0; i < twoIndex+1; ) {
            if (nums[i] == 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, twoIndex, i);
                twoIndex--;
            } else {
                i++;
            }
        }

    }

    void swap(int[] nums, int zeroIndex, int i) {
        int temp = nums[i];
        nums[i] = nums[zeroIndex];
        nums[zeroIndex] = temp;
    }
}
