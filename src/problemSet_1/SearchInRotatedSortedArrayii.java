package problemSet_1;

public class SearchInRotatedSortedArrayii {

    public static void main(String[] arg) {
        System.out.println(search(new int[] {1,0,1,1,1}, 0));
    }

    public static boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }


    static boolean search(int[] nums, int target, int start, int end) {

        for (int i = start; i < end && nums[i] == nums[i+1]; i++) {
            if (nums[start] == target) return true;
            start = start+1;
        }

        for (int i = end; i > 0 && nums[i] == nums[i-1]; i--) {
            if (nums[end] == target) return true;
            end = end-1;
        }


        while(start <= end && nums[start] == nums[end]) {
            if (nums[start] == target) return true;
            start++;
        }

        if (start > end) return false;
        int mid = start + (end-start)/2;
        if (target == nums[mid]) return true;


        if (nums[end] > nums[mid]) {
            if (target > nums[mid] && target <= nums[end])
                return search(nums, target, mid+1, end);
            return search(nums, target, start, mid-1);
        }

        if (target < nums[mid] && target >= nums[start])
            return search(nums, target, start, mid-1);
        return search(nums, target, mid+1, end);
    }
}
