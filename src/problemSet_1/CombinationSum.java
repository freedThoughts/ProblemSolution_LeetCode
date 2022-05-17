package problemSet_1;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    public static void main(String[] str) {
        System.out.println(combinationSum(new int[] {2, 3, 5}, 8));
    }


    // Combination Approach **************
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        combination2(candidates, target, 0, new ArrayList(), result);
        return result;
    }


    // Every method call
    private static void combination2(int[] candidates, int target, int index, List<Integer> currentList, List<List<Integer>> result) {
        System.out.println("Trying for index: " + index + " currentList: " + currentList);
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList(currentList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            currentList.add(candidates[i]);

            // It will either all one more Integer in currentList Or currentList is done adding any new Integer
            // In both of the cases, you need to remove the last Integer from currentList
            combination2(candidates, target - candidates[i], i, currentList, result);
            currentList.remove(currentList.size()-1);
        }
    }

    // Permutation Approach ***************
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < candidates.length; i++)
            // For every candidateIndex, new currentList
            combination(result, candidates, target, i, new ArrayList(), 0,0);
        return result;
    }

    private static void combination(
            List<List<Integer>> result,
            int[] candidates,
            int target,
            int candidateIndex,
            List<Integer> currentList,
            int currentListIndexToAdd,
            int currentCount) {


        System.out.println("Try for " + candidates[candidateIndex] + " in " + currentList);
        if (currentCount + candidates[candidateIndex] > target) {
            return;
        }

        // Add to currentList at appropriate Index
        if (currentListIndexToAdd == currentList.size()) {
            currentList.add(candidates[candidateIndex]);
        } else {
            currentList.set(currentListIndexToAdd, candidates[candidateIndex]);
        }

        currentCount += candidates[candidateIndex];

        System.out.println("CurrentList : " + currentList);

        // Found the list, add to result till appropriate index and return
        if (currentCount == target) {
            List<Integer> ls = new ArrayList();
            for (int i = 0; i <= currentListIndexToAdd; i++)
                ls.add(currentList.get(i));
            result.add(ls);

            System.out.println("Result : "+ result);
            
            return;
        }

        // Not found the list, need to add more elements in the currentList
        currentListIndexToAdd ++;
        combination(result, candidates, target, candidateIndex, currentList, currentListIndexToAdd,currentCount);

        // Current element from candidateArr check is done, check for next element from candidateArr
        while(candidateIndex +1 < candidates.length) {
            candidateIndex++;
            combination(result, candidates, target, candidateIndex, currentList, currentListIndexToAdd,currentCount);
        }
    }
}

