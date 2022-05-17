package problemSet_1;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        for(int i = 0, j = height.length-1; i<j; ) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j-i));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return area;
    }
}
