package problemSet_1;

import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];

        int forwardPointer = 0;
        for(int i = nums.length-1; i >= 0;i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();

            } else {
                while(forwardPointer < i && nums[forwardPointer] <= nums[i])
                    forwardPointer++;
                if (nums[forwardPointer] > nums[i]) {
                    ans[i] = nums[forwardPointer];
                } else ans[i] = -1;

            }
            stack.push(nums[i]);
        }
        return ans;

    }
}
