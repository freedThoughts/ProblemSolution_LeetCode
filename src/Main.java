


import java.util.Stack;


public class Main {

    /*

    Sequence 1:
RRGG
output:
RRGG


Sequence 2:
RRGGBBBBGGBG

output:
RRBG
     */

    public static void main(String[] arg) {

        String input = "RRR";

        Stack<Node> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new Node(ch, 1));
                continue;
            }

            if (stack.peek().ch == ch) {
                Node node = stack.pop();
                node.freq = node.freq +1;
                stack.push(node);
                //stack.peek().freq = 1 + stack.peek().freq;
                continue;
            }

            if (stack.peek().freq > 2) {
                stack.pop();
            }

            if (stack.peek().ch == ch) {
                Node node = stack.pop();
                node.freq = node.freq +1;
                stack.push(node);
                //stack.peek().freq = 1 + stack.peek().freq;
                continue;
            }

            stack.push(new Node(ch, 1));
        }

        if (stack.peek().freq > 2) {
            stack.pop();
        }


        //StringBuffer sb = new StringBuffer();
        String ans = "";
        while (!stack.isEmpty()) {
            Node node = stack.pop();


            char[] arr = new char[1];
            arr[0] = node.ch;
            String str = new String(arr);
            while (node.freq > 0) {
                ans = str.concat(ans);
                node.freq--;
            }
        }


        System.out.print(ans);






    }

    static class Node {
        char ch;
        int freq;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

    }
}
