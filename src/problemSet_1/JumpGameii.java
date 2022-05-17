package problemSet_1;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGameii {

    public int jump(int[] nums) {

        int[] jumpCount = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            for (int val = 1; val <= nums[i]; val++) {
                if (i+val == nums.length-1) return jumpCount[i] +1;
                if (i+ val >=  nums.length) continue;
                if (jumpCount[i+val] == 0 || jumpCount[i+val] > jumpCount[i] +1) {
                    jumpCount[i+val] = jumpCount[i] +1;
                }
            }
        }

        return jumpCount[jumpCount.length-1];
    }

    // Time exceed
    public int jump2(int[] nums) {

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(null);

        while(!queue.isEmpty()) {
            Integer indexReached = queue.poll();
            if (indexReached == null) {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
                count ++;
                continue;
            }

            if (indexReached == nums.length-1) return count;
            for (int i = 1; i <= nums[indexReached]; i++) {
                if (indexReached + i < nums.length)
                    queue.offer(indexReached + i);
            }
        }
        return -1;
    }
}
