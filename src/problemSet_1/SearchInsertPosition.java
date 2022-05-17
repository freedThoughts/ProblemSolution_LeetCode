package problemSet_1;
// https://leetcode.com/problems/search-insert-position/submissions/
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high) {
            if (low == high) {
                if (nums[low] >= target ) return low;
                return low+1;
            }

            int mid = low + (high-low)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                low = mid +1;
                continue;
            }
            high = mid-1;
        }
        return low;

    }
}
