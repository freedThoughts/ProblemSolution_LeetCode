package problemSet_1;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-duplicate-number/submissions/
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return find(nums, 0, nums.length-1);

    }

    int find(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int mid = start + (end-start)/2;
        if ((mid != 0 && nums[mid-1] == nums[mid]) || (mid != nums.length-1 && nums[mid] == nums[mid+1]))
            return nums[mid];
        if (nums[mid] <= mid) return find(nums, start, mid-1);
        return find(nums, mid+1, end);
    }
}
