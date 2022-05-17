package problemSet_1;

import java.util.Stack;

// https://leetcode.com/problems/validate-stack-sequences/submissions/
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while(i < pushed.length) {
            stack.push(pushed[i]);
            i++;

            while(!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }


        if (!stack.isEmpty() || j != popped.length) return false;
        return true;
    }
}
