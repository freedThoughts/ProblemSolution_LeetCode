package problemSet_1;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/submissions/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        backTracking(results, n, k, new ArrayList(), 0);
        return results;
    }

    void backTracking(List<List<Integer>> results, int n, int k, List<Integer> currentList, int i) {
        if (currentList.size() == k) {
            results.add(new ArrayList(currentList));
            return;
        }

        for (int j = i+1; j <= n; j++) {
            currentList.add(j);
            backTracking(results, n, k, currentList, j);
            currentList.remove(currentList.size()-1);
        }

    }
}
