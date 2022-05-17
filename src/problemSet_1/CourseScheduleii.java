package problemSet_1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
// https://leetcode.com/problems/course-schedule-ii/submissions/
public class CourseScheduleii {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return new int[]{0};
        Set<Integer>[] courses = new Set[numCourses];
        for (int[] pre : prerequisites) {
            if (courses[pre[0]] == null) courses[pre[0]] = new HashSet<>();
            courses[pre[0]].add(pre[1]);
        }

        Set<Integer> visitedSet = new HashSet<Integer>();
        Set<Integer> currentSet = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (visitedSet.contains(i)) continue;
            if (!dfs(i, visitedSet, queue, courses, currentSet)) return new int[0];
        }

        int[] ans = new int[numCourses];
        for (int i= 0; i < ans.length; i++)
            ans[i] = queue.remove();

        return ans;

    }

    boolean dfs(int i, Set<Integer> visitedSet, Queue<Integer> queue, Set<Integer>[] courses, Set<Integer> currentSet){

        if (visitedSet.contains(i)) return true;
        if (currentSet.contains(i)) return false;
        if (courses[i] == null || courses[i].size() == 0) {
            visitedSet.add(i);
            queue.add(i);
            return true;
        }

        currentSet.add(i);
        for (int j : courses[i]) {
            if (!dfs(j, visitedSet, queue, courses, currentSet)) return false;
        }

        currentSet.remove(i);
        visitedSet.add(i);
        queue.add(i);
        return true;
    }
}
