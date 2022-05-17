package problemSet_1;
// https://leetcode.com/problems/house-robber-ii/submissions/
public class HouseRobberii {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int secLast = 0;
        int last = 0;
        int ans = 0;
        for(int i = 0; i < nums.length-1; i++) {
            int val = Math.max(last, secLast + nums[i]);
            ans = Math.max(ans, val);
            secLast = last;
            last = val;
        }

        secLast = 0;
        last = 0;
        for(int i = 1; i < nums.length; i++) {
            int val = Math.max(last, secLast + nums[i]);
            ans = Math.max(ans, val);
            secLast = last;
            last = val;
        }

        return ans;

    }
}
