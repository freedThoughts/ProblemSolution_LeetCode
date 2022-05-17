package problemSet_1;

import java.util.Arrays;
// https://leetcode.com/problems/magnetic-force-between-two-balls/submissions/
public class MagneticForceBetweenTwoBalls {

    public static void main(String[] arg) {
        System.out.println(maxDistance(new int[] {79,74,57,22}, 4));
    }


    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        if (m == 2) return position[position.length-1] - position[0];
        int start = position[0];
        int end = position[position.length-1];
        int mid = start + (end - start)/2;
        int ans = 0;
        while(start <= end) {
            if(isValid(position, mid - position[0], m)) {
                ans = mid - position[0];
                start = mid+1;
            } else {
                end = mid-1;
            }
            mid = start + (end - start)/2;
        }
        return ans;
    }

    static boolean isValid(int[] position, int gap, int m) {
        int prev = position[0];
        m--;

        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= gap) {
                m--;
                prev = position[i];
                if (m == 0) return true;
            }
        }
        return false;
    }
}
