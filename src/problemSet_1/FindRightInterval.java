package problemSet_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-right-interval/
public class FindRightInterval {
    public static void main(String[] arg) {
        int[][] intervals = {{3,4},{2,3},{1,2}};
        int[] ans = findRightInterval(intervals);
        Arrays.stream(ans)
                .forEachOrdered(System.out::println);
    }

    public static int[] findRightInterval(int[][] intervals) {
        if (intervals.length < 2) return new int[] {-1};

        Map<Integer, Integer> startIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < intervals.length; i++)
            startIndexMap.put(intervals[i][0], i);

        Arrays.sort(intervals,
                (a, b) -> ((Integer)a[0]).compareTo((Integer)b[0])
        );

        int [] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {

            Integer m = binarySearch(intervals, intervals[i][1], 0, intervals.length-1);
            if (m == null) {
                ans[startIndexMap.get(intervals[i][0])] = -1;
                continue;
            }

            Integer a = startIndexMap.get(m);
            ans[startIndexMap.get(intervals[i][0])] = a;
        }

        return ans;
    }

    static Integer binarySearch(int[][] intervals, int input, int lIndex, int rIndex) {
        if (lIndex > rIndex) return null;
        if (lIndex == rIndex)  {
            if (intervals[lIndex][0] >= input) return intervals[lIndex][0];
            return null;
        }

        int mid = lIndex + (rIndex - lIndex)/2;
        if (intervals[mid][0] == input) return intervals[mid][0];
        if (intervals[mid][0] < input) return binarySearch(intervals, input, mid +1, rIndex);
        if (intervals[mid-1][0] == input) return intervals[mid-1][0];
        if (intervals[mid-1][0] < input) return intervals[mid][0];
        return binarySearch(intervals, input, lIndex, mid-1);

    }

}
