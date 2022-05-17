package zalando;

import java.util.Stack;
// Only 75% correctness ... this solution .. 9/12 passed
// would have taken long Or exception handling
public class Test1 {

    public int solution(String S) {
        String[] arr = S.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            int val = isNumber(arr[i]);
            if (val >= 1048576) return -1;
            if (val > 0) {
                stack.push(val);
                continue;
            }

            if ("DUP".equals(arr[i])) {
                stack.push(stack.peek());
                continue;
            }

            if ("POP".equals(arr[i])) {
                if (stack.isEmpty()) return -1;
                stack.pop();
                continue;
            }

            if ("+".equals(arr[i])) {
                if (stack.isEmpty()) return -1;
                int a = stack.pop();
                if (stack.isEmpty()) return -1;
                int b = stack.pop();
                val = a+b;
                if (val >= 1048576) return -1;
                stack.push(val);
                continue;
            }

            // "-" check should be added
            if (stack.isEmpty()) return -1;
            int a = stack.pop();
            if (stack.isEmpty()) return -1;
            int b = stack.pop();
            val = a-b;
            if (val >= 1048576 || val < 0) return -1;
            stack.push(val);
            continue;

        }


        return stack.peek();
    }

    int isNumber(String str) {
        int val = -1;
        try{
            val = Integer.valueOf(str);
        } catch(NumberFormatException e){
            return val;
        }
        return val;


    }
}
