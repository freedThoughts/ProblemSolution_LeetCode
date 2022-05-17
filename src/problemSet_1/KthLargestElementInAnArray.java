package problemSet_1;

import java.util.TreeSet;

// https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length <  k) return -1;
        TreeSet<Integer> set = new TreeSet<>((a, b) -> {
            int i = a.compareTo(b);
            if (i == 0) return -1;
            return i;
        });
        for (int i = 0; i < nums.length; i++) {
            if (set.size() < k) set.add(nums[i]);
            else if (set.first() < nums[i]) {
                set.pollFirst();
                set.add(nums[i]);
            }
        }

        return set.first();
    }
}
