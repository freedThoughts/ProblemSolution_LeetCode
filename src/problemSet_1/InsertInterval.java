package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] arg) {
        int[][] input =  {{1, 3}, {6, 9}};
        int[][] result = insert(input, new int[] {2, 5});
        Arrays.stream(result)
                .forEach(arr -> System.out.println(arr[0] + " " + arr[1]));

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        boolean isNewIntervalAdded = false;

        List<int[]> arrList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < newInterval[0]) {
                arrList.add(intervals[i]);
                continue;
            }

            if (!isNewIntervalAdded) {
                mergeOrAdd(arrList, newInterval);
                isNewIntervalAdded = true;
                i--;
                continue;
            }

            mergeOrAdd(arrList, intervals[i]);
        }

        return arrList.toArray(new int[arrList.size()][2]);

    }

    static void mergeOrAdd(List<int[]> arrList, int[] interval) {

        int[] lastElement = arrList.get(arrList.size()-1);

        if (interval[0] <= lastElement[1]) {
            lastElement[0] = Math.min(lastElement[0], interval[0]);
            lastElement[1] = Math.max(lastElement[1], interval[1]);
            return;
        }

        arrList.add(interval);
    }
}
