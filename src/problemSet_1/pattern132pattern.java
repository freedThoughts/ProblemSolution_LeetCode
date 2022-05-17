package problemSet_1;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/submissions/
public class pattern132pattern {


    // Time Complexity = O(n)
    // [1, 0, 1, -4, -3]
    // [2, 3, -1, 4]
    public boolean find132pattern2(int[] nums) {
        int[] minArr = new int[nums.length];
        minArr[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            minArr[i] = Math.min(minArr[i-1], nums[i]);

        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i>=0; i--) {
            if (nums[i] <= minArr[i]) continue;
            while(!stack.isEmpty() && stack.peek() <= minArr[i]) stack.pop();
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }

            if (nums[i] > stack.peek()) return true;
            stack.push(nums[i]);

        }
        return false;
    }

    public boolean find132pattern(int[] nums) {

        int[] minArr = new int[nums.length];
        minArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            minArr[i] = Math.min(minArr[i-1], nums[i]);

        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= minArr[i])
                stack.pop();
            if (!stack.isEmpty() && nums[i] > stack.peek() ) return true;
            stack.push(nums[i]);
        }

        return false;
    }
}
