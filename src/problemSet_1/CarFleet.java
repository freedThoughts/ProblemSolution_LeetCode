package problemSet_1;

import java.util.Arrays;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a, b) -> ((Integer)a[0]).compareTo((Integer)b[0]));

        int count = 0;
        double lastTime = 0.0;

        for(int i = n-1; i >= 0; i--) {
            int dis = target - arr[i][0];
            double timeReq = (double)dis / arr[i][1];
            if (timeReq > lastTime) {
                count++;
                lastTime = timeReq;
            }
        }

        return count;
    }
}
