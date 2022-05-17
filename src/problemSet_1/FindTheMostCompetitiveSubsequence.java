package problemSet_1;

import java.util.Stack;
// https://leetcode.com/problems/find-the-most-competitive-subsequence/submissions/
public class FindTheMostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[k];
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] < stack.peek() && (nums.length - i + stack.size()) > k) stack.pop();
            if (stack.size() < k) ans[stack.size()] = nums[i];
            stack.push(nums[i]);
        }
        return ans;
    }
}
