package problemSet_1;

import java.util.Stack;
// https://leetcode.com/problems/longest-valid-parentheses/submissions/
public class LongestValidParentheses {

    public int longestValidParentheses2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(stack.isEmpty() ? i+1 : i - stack.peek(), max);
                continue;
            }

            stack.push(i);
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                open++;
            if (s.charAt(i) == ')')
                close++;
            if (open == close)
                max = Math.max(max, open+close);
            if (close > open) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;

        for(int i = s.length()-1; i >= 0; i--) {

            if (s.charAt(i) == '(')
                open++;
            if (s.charAt(i) == ')')
                close++;
            if (open == close)
                max = Math.max(max, open+close);
            if (close < open) {
                open = 0;
                close = 0;
            }
        }

        return max;
    }
}
