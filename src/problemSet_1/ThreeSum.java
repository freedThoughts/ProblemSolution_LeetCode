package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/3sum/
public class ThreeSum {


    /**
     * if (1, 2, 3) not equal to (2, 1, 3) then j should start from 0
     * if (1, 2, 3) is equal to (2, 1, 3) then, j should start from i+1;
     *
     *  All answers set are in ascending order which means i then, j then k. This the way code have NOT included duplicate sets.
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(i == j) j++;
            while(i == k) k--;
            while(j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else
                    j++;
            }
        }
        return results;
    }



    public static List<List<Integer>> threeSum2(int[] nums) {

        Set<List<Integer>> setResult = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0, k = nums.length-1; j < k; ) {
                if (j == i) {
                    j++;
                    continue;
                }
                if (k == i){
                    k--;
                    continue;
                }

                if ((nums[i] + nums[j] + nums[k]) < 0) {
                    j++;
                    continue;
                }
                if ((nums[i] + nums[j] + nums[k]) > 0) {
                    k--;
                    continue;
                }
                List<Integer> list = new ArrayList();
                if (i < j) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                } else if (i < k) {
                    list.add(nums[j]);
                    list.add(nums[i]);
                    list.add(nums[k]);
                } else {
                    list.add(nums[j]);
                    list.add(nums[k]);
                    list.add(nums[i]);
                }
                setResult.add(list);
                j++;
                k--;

            }
        }
        return new ArrayList(setResult);
    }

    public static void main(String[] arg) {
        System.out.println(threeSum2(new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
