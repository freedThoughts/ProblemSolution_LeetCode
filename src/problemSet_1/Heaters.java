package problemSet_1;

import java.util.Arrays;
// https://leetcode.com/problems/heaters/submissions/
public class Heaters {
    public static int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int results = Integer.MIN_VALUE;
        int h = 0;
        for(int i = 0; i < houses.length; i++) {
            int diff = houses[i] > heaters[h] ? houses[i] - heaters[h] : heaters[h] - houses[i];
            int m = h+1;
            while(m < heaters.length && diff >= (houses[i] > heaters[m] ? houses[i] - heaters[m] : heaters[m] - houses[i])) {
                diff = (houses[i] > heaters[m] ? houses[i] - heaters[m] : heaters[m] - houses[i]);
                m++;
            }
            h = m-1;
            results = Math.max(results, diff);
        }
        return results;
    }
}
