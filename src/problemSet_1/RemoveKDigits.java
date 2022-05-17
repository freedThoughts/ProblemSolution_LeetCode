package problemSet_1;

import java.util.Stack;
// https://leetcode.com/problems/remove-k-digits/submissions/
public class RemoveKDigits {


    public String removeKdigits3(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            while(k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            if (stack.isEmpty() && digit == 0) continue;
            stack.push(digit);
        }

        while(!stack.isEmpty() && k > 0) {
            k--;
            stack.pop();
        }

        if (stack.size() == 0) return "0";
        char[] ansArr = new char[stack.size()];

        for(int i = ansArr.length-1; i >= 0; i--)
            ansArr[i] = (char) (stack.pop() + '0');
        return new String(ansArr);
    }


    public String removeKdigits(String num, int k) {

        if(num.length() == k) return "0";
        char[] ans = new char[num.length()-k];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length() && (k > 0 || stack.size() < num.length()-k); i++) {
            while(!stack.isEmpty() && num.charAt(i) < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }

            if (stack.size() < ans.length) ans[stack.size()] = num.charAt(i);
            stack.push(num.charAt(i));
        }
        String result =  new String(ans);
        int i = 0;
        for (; i < result.length()-1 && result.charAt(i) == '0'; i++);
        return result.substring(i, result.length());
    }


    public String removeKdigits2(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - 48;
            while(!stack.isEmpty() && stack.peek() > number && k > 0) {
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && number == 0) continue;
            stack.push(number);
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            if (k > 0) {
                stack.pop();
                k--;
                continue;
            }
            sb = new StringBuffer(stack.pop().toString()).append(sb);
        }
        if (sb.length() == 0) sb = new StringBuffer("0");
        return new String(sb);

    }
}
