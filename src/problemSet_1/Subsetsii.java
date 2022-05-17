package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/subsets-ii/submissions/
public class Subsetsii {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        backTrack(results, nums, new ArrayList<>(), 0);
        return results;

    }

    void backTrack(List<List<Integer>> results, int[] nums, List<Integer> currentList, int i){
        results.add(new ArrayList<>(currentList));

        for(int j = i; j < nums.length; j++){
            if (j != i && nums[j] == nums[j-1]) continue;
            currentList.add(nums[j]);
            backTrack(results, nums, currentList, j+1);
            currentList.remove(currentList.size()-1);

        }
    }
}
