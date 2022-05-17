package problemSet_1;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/submissions/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0;
        for (int i : nums) {
            if(set.contains(i-1)) continue;
            int val = 1;

            int j = i;
            while(set.contains(j+1)) {
                val++;
                j++;
            }
            ans = Math.max(ans, val);
        }
        return ans;
    }

    int countLeft(Set<Integer> set, int i) {
        return set.contains(i) ? 1 + countLeft(set, i-1) : 0;
    }

    int countRight(Set<Integer> set, int i){
        return set.contains(i) ? 1 + countRight(set, i+1) : 0;
    }
}
