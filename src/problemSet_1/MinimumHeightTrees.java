package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/minimum-height-trees/
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) return Arrays.asList(0);
        Set<Integer>[] arr = new HashSet[n];
        for(int[] edge : edges){
            if (arr[edge[0]] == null) arr[edge[0]] = new HashSet<Integer>();
            if (arr[edge[1]] == null) arr[edge[1]] = new HashSet<Integer>();
            arr[edge[0]].add(edge[1]);
            arr[edge[1]].add(edge[0]);
        }

        List<Integer> leaveNodes = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            if(arr[i] != null && arr[i].size() == 1) leaveNodes.add(i);
        }

        int remainingNodeCount = n;

        while (remainingNodeCount > 2) {
            remainingNodeCount-= leaveNodes.size();
            List<Integer> newleaveNodes = new ArrayList<Integer>();
            for (Integer leave : leaveNodes) {
                int edge = arr[leave].iterator().next();
                arr[edge].remove(leave);
                if (arr[edge].size() == 1) {
                    newleaveNodes.add(edge);
                }
            }

            leaveNodes = newleaveNodes;
        }

        return leaveNodes;
    }
}
