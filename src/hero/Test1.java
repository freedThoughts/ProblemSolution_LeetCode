package hero;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Test1 {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        set.add('B');
        set.add('C');

        map.put('A', set);

        set = new HashSet<>();
        set.add('D');
        set.add('C');
        map.put('B', set);

        set = new HashSet<>();
        set.add('D');
        map.put('C', set);

        char[] arr = S.toCharArray();
        // char ch : S.toCharArray()

        for(int i = arr.length-1; i >= 0; i--) {
            char ch = arr[i];
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            while(!stack.isEmpty() && map.containsKey(ch) && map.get(ch).contains(stack.peek()))
                stack.pop();
            if (!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()).contains(ch))
                continue;
            stack.push(ch);
        }

        return stack.size();
    }
}
