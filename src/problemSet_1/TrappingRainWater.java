package problemSet_1;
// https://leetcode.com/problems/trapping-rain-water/submissions/
public class TrappingRainWater {

    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int ans = 0;
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
            ans = ans - height[i] + Math.min(leftMax[i], rightMax[i]);

        }

        return ans;

    }
}
