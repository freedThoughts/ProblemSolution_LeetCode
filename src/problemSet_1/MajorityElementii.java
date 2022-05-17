package problemSet_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/majority-element-ii/submissions/
public class MajorityElementii {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();

        int req = nums.length/3;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            Integer count = map.get(i);
            if (count != null && count > req) continue;
            if (count == null) count = 1;
            else count = count +1;
            map.put(i, count);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > req) results.add(entry.getKey());
        }

        return results;

    }
}
