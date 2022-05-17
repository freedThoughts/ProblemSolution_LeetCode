package problemSet_1;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
public class RemoveDuplicatesFromSortedArrayii {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int slowIndex = 1, fastIndex = 2;
        for(; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != nums[slowIndex] || nums[fastIndex] != nums[slowIndex-1]) {
                nums[++slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex+1;
    }
}
