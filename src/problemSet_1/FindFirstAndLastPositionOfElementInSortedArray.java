package problemSet_1;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length-1);
    }

    private int[] searchRange(int[] nums, int target, int start, int end) {
        if (start > end)
            return new int[] {-1, -1};

        int mid = start + (end-start)/2;
        if (nums[mid] == target) {
            int [] firstPartArr = new int[] {mid, mid};
            if (mid != start && nums[mid-1] == target) {
                firstPartArr = searchRange(nums, target, start, mid-1);
            }

            int[] secondPartArr = new int[] {mid, mid};
            if (mid != end && nums[mid+1] == target) {
                secondPartArr = searchRange(nums, target, mid+1, end);
            }

            return new int[] {firstPartArr[0], secondPartArr[1]};
        }

        if (target < nums[mid]) {
            return searchRange(nums, target, start, mid-1);
        }
        return searchRange(nums, target, mid+1, end);
    }




    public int[] searchRange2(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length-1, target, new int[]{-1, -1});

    }

    int[] binarySearch(int[] nums, int start, int end, int target, int[] ans){
        if (start > end) {
            return ans;
        }

        int mid = start + (end-start)/2;
        if (nums[mid] == target) {
            if (ans[0] == -1) {
                ans = new int[]{mid, mid};
                int[] lArr = binarySearch(nums, start, mid-1, target, ans);
                int[] rArr = binarySearch(nums, mid+1, end, target, ans);
                ans[0] = lArr[0];
                ans[1] = rArr[1];
                return ans;

            }

            else if (mid < ans[0]) {
                ans[0] = mid;
                return binarySearch(nums, start, mid-1, target, ans);
            } else {
                ans[1] = mid;
                return binarySearch(nums, mid+1, end, target, ans);
            }
        }

        if (nums[mid] > target) return binarySearch(nums, start, mid-1, target, ans);
        return binarySearch(nums, mid+1, end, target, ans);
    }
}
