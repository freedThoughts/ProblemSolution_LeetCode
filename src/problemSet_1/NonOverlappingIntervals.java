package problemSet_1;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (a, b) -> ((Integer) a[1]).compareTo((Integer) b[1]));
        int lastEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) ans++;
            else lastEnd = intervals[i][1];
        }
        return ans;
    }
}
