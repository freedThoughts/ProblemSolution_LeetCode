package problemSet_1;
// https://leetcode.com/problems/single-element-in-a-sorted-array
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }

    int binarySearch(int[] nums, int start, int end) {
        if(start == end) return nums[start];

        int mid = (end - start)/2 + start;

        // Odd
        if (mid%2 == 0) {
            if (mid == nums.length-1 || nums[mid] != nums[mid+1]) {
                if (mid == 0 || nums[mid] != nums[mid-1]) return nums[mid];
                else return binarySearch(nums, start, mid-1);
            }
            return binarySearch(nums, mid+1, end);
        }

        if (mid == 0 || nums[mid] != nums[mid-1]) {
            if (mid == nums.length-1 || nums[mid] != nums[mid+1]) return nums[mid];
            else return binarySearch(nums, start, mid-1);
        }

        return binarySearch(nums, mid+1, end);
    }
}
