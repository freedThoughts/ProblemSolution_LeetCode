package problemSet_1;

import java.util.TreeSet;
// https://leetcode.com/problems/contains-duplicate-iii/submissions/
public class ContainsDuplicateiii {

    public static void main(String[] arg) {

        TreeSet<Integer> set = new TreeSet<>((a, b)-> {
            int value = a.compareTo(b);
            if (value == 0) return 1;
            return value;
        });
        set.add(1);
        set.add(1);

        set.remove(1);

        System.out.println();

        //System.out.println(containsNearbyAlmostDuplicate2(new int[]{1,5,9,1,5,9}, 2, 3));
    }

    static public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

        if (k == 0) return false;

        TreeSet<Integer> treeSet = new TreeSet<>((a, b) -> {
            int j = a.compareTo(b);
            if (j == 0) return 1;
            return j;
        });
        for(int i = 0; i < nums.length; i++) {
            Integer v = treeSet.ceiling(nums[i]);
            if (v != null && (v - (long)nums[i]) <= t) return true;

            v = treeSet.floor(nums[i]);
            if (v != null && (long)nums[i] - v <= t) return true;

            if (treeSet.size() == k)
                treeSet.remove(nums[i-k]);

            treeSet.add(nums[i]);
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int diff = 1; diff <= k; diff++) {
            for (int i = diff; i < nums.length; i++) {
                long d = nums[i] > nums[i-diff] ? (long)nums[i] - nums[i-diff] : nums[i-diff] - (long)nums[i];
                if (d <= t) return true;
            }
        }
        return false;

    }
}
