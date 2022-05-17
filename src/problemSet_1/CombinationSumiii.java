package problemSet_1;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/submissions/
public class CombinationSumiii {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> results = new ArrayList<>();
        dfs(results, k, n, 1, new ArrayList<>());
        return results;

    }

    void dfs(List<List<Integer>> results, int k, int n, int i, List<Integer> currentList) {
        if (k == 0 && n == 0) {
            results.add(new ArrayList<>(currentList));
            return;
        }
        if (k == 0 && n != 0) return;
        if (i > 9 || n < 0) return;

        for (int j = i; j <= 9; j++) {
            currentList.add(j);
            dfs(results, k-1, n-j, j+1, currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}

