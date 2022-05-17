package problemSet_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
// https://leetcode.com/problems/remove-duplicate-letters/submissions/
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {

        // Replace with boolean[] of len 26
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            Integer count = freqMap.get(ch);
            if (count == null) count = 1;
            else count++;
            freqMap.put(ch, count);
        }

        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {

            freqMap.put(ch, freqMap.get(ch) -1);
            if (set.contains(ch)) continue;

            while(!stack.isEmpty() && stack.peek() > ch && freqMap.get(stack.peek()) > 0) {
                set.remove(stack.pop());
            }

            stack.push(ch);
            set.add(ch);
        }

        char[] arr = new char[stack.size()];
        for(int i = arr.length-1; i >= 0; i--) {
            arr[i] = stack.pop();
        }

        return new String(arr);
    }
}
