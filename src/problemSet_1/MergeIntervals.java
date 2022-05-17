package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (arr1, arr2) -> ((Integer)arr1[0]).compareTo((Integer)arr2[0]));

        List<int[]> arrList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (arrList.size() == 0 || arrList.get(arrList.size()-1)[1] < intervals[i][0]) {
                arrList.add(intervals[i]);
                continue;
            }

            int[] lastElement = arrList.get(arrList.size()-1);
            lastElement[0] = Math.min(lastElement[0], intervals[i][0]);
            lastElement[1] = Math.max(lastElement[1], intervals[i][1]);
        }

        return arrList.toArray(new int[arrList.size()][2]);

    }
}
