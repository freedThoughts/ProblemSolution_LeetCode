package problemSet_1;

import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> ((Integer)a[1]).compareTo((Integer)(b[1])));
        int count = 1;
        for (int i = 1; i < events.length; i++)
            if (events[i-1][1] <= events[i][0]) count++;
        return count;

    }

    public static void main(String[] arg) {

    }
}
