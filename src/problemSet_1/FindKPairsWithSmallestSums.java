package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> results = new ArrayList<>();
        int[] JArr = new int[k];
        while(results.size() < k) {
            for(int i = 0; i < nums1.length && results.size() < k; ) {
                while(nums1[i] + nums2[JArr[i]] < nums1[i+1] + nums2[JArr[i+1]] && results.size() < k) {
                    results.add(Arrays.asList(nums1[i], nums2[JArr[i]]));
                    JArr[i]++;
                }
                i++;
                if (i == nums1.length) i = 0;
            }
        }

        return results;

    }
}
