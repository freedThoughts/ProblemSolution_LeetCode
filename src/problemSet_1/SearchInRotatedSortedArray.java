package problemSet_1;

public class SearchInRotatedSortedArray {
    public static void main(String[] arg) {
        System.out.println(search(new int[] {5, 1, 3}, 3));
    }
    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }
    private static int search(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return -1;

        int mid = (endIndex - startIndex)/2 + startIndex;
        if (nums[mid] == target)
            return mid;

        // StartIndex and endIndex check is added to avoid >= or <= in latter part of code
        if (nums[startIndex] == target)
            return startIndex;
        if(nums[endIndex] == target)
            return endIndex;


        if (nums[startIndex] < nums[mid]) {
            if (nums[startIndex] < target && target < nums[mid]) {
                return search(nums, target, startIndex+1, mid-1);
            }
            return search(nums, target, mid+1, endIndex-1);
        }

        if (nums[mid] < nums[endIndex]) {
            if (nums[mid] < target && target < nums[endIndex])
                return search(nums, target, mid+1, endIndex-1);
            return search(nums, target, startIndex+1, mid-1);
        }

        return -1;
    }
}
