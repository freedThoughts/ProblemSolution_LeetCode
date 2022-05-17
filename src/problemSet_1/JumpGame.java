package problemSet_1;

// https://leetcode.com/problems/jump-game/submissions/
public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean [] arr = new boolean[nums.length];
        arr[0] = true;
        for(int i = 0; i < nums.length; i++) {
            if (arr[i]) {
                for (int j = 0; j <= nums[i]; j++) {
                    if (i+j == nums.length-1) return true;
                    arr[i+j] = true;
                }
            }
        }
        return false;
    }
}
