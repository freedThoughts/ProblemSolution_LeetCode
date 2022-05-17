package problemSet_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {

    public static void main(String[] arg) {
        System.out.println(smallestSubsequence(
                "cbacdcbc"));
    }

    public static String smallestSubsequence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer val = map.get(s.charAt(i));
            val = val == null ? 1: val+1;
            map.put(s.charAt(i), val);
        }

        char[] ans = new char[s.length()];

        Set<Character> usedSet = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while(!stack.isEmpty() && ch < stack.peek() && !usedSet.contains(ch) && map.containsKey(stack.peek())){
                //stack.pop();
                usedSet.remove(stack.pop());
            }

            if (usedSet.contains(ch)) continue;

            ans[stack.size()] = ch;
            usedSet.add(ch);
            stack.push(ch);
            Integer val = map.get(ch);
            if (val == 1) map.remove(ch);
            else map.put(ch, val-1);

        }

        return new String(ans, 0, stack.size());
    }
}
