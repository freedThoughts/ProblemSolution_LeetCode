package zalando;

import java.util.Stack;

public class Test2 {
    public String solution(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if ('A' == ch && !stack.isEmpty() && stack.peek() == 'B' ) {
                stack.pop();
                continue;
            }

            if ('B' == ch && !stack.isEmpty() && stack.peek() == 'A' ) {
                stack.pop();
                continue;
            }

            if ('C' == ch && !stack.isEmpty() && stack.peek() == 'D' ) {
                stack.pop();
                continue;
            }

            if ('D' == ch && !stack.isEmpty() && stack.peek() == 'C' ) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }

        char[] ans = new char[stack.size()];
        for(int i = ans.length-1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return new String(ans);

    }
}
