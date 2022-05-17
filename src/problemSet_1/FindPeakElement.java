package problemSet_1;
// https://leetcode.com/problems/find-peak-element/submissions/
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {

            int mid = start + (end-start)/2;

            if (start == end) return mid;


            if ((mid == 0 || nums[mid] > nums[mid-1]) && ( mid == nums.length-1 || nums[mid] > nums[mid+1]) ) {
                return mid;
            }


            if(nums[mid] < nums[mid+1]) {
                start = mid +1;
                continue;
            }

            if (nums[mid] > nums[mid+1]) {
                end = mid-1;
                continue;
            }

        }

        return -1;
    }
}
