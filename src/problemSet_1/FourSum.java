package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/4sum/
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                for(int m = 0, n = nums.length-1; m < n; ) {
                    if (m == i || m == j) {
                        m++;
                        continue;
                    }
                    if(n == i || n == j) {
                        n--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (target > sum) {
                        m++;
                        continue;
                    }
                    if (target < sum) {
                        n--;
                        continue;
                    }

                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    Collections.sort(list);
                    set.add(list);
                    m++;
                    n--;

                }
            }
        }
        List<List<Integer>> result = new ArrayList();
        set.forEach(s -> result.add(s));
        return result;
    }
}
