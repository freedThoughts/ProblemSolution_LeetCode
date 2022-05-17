package problemSet_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// https://leetcode.com/problems/course-schedule/submissions/
// Find cycle in directed graph **************

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] arr : prerequisites) {
            Set<Integer> set = map.get(arr[0]);
            if (set == null) set = new HashSet<>();
            set.add(arr[1]);
            map.put(arr[0], set);
        }

        Set<Integer> checkedSet = new HashSet<>();
        Set<Integer> currentSet = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if (checkedSet.contains(i)) continue;
            if (!dfs(map, checkedSet, currentSet, i)) return false;
        }

        return true;
    }

    boolean dfs(Map<Integer, Set<Integer>> map, Set<Integer> checkedSet, Set<Integer> currentSet, int i) {
        if (checkedSet.contains(i)) return true;
        if (currentSet.contains(i)) return false;

        Set<Integer> set = map.get(i);
        if (set == null) {
            checkedSet.add(i);
            return true;
        }

        currentSet.add(i);
        for (int j : set) {
            if (!dfs(map, checkedSet, currentSet, j)) return false;
        }

        currentSet.remove(i);
        checkedSet.add(i);
        return true;
    }
}
