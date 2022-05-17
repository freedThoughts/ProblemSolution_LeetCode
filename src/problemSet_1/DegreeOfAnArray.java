package problemSet_1;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/degree-of-an-array/submissions/
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();
        int degree = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {

            if(!startMap.containsKey(nums[i]))
                startMap.put(nums[i], i);

            Integer val = degreeMap.get(nums[i]);
            if (val == null) val = 1;
            else val = val +1;
            degreeMap.put(nums[i], val);

            if (val < degree) continue;

            if (val == degree) {
                ans = Math.min(ans, i - startMap.get(nums[i]) + 1);
            }

            else{
                degree = val;
                ans = i - startMap.get(nums[i]) + 1;
            }
        }

        return ans;

    }
}
