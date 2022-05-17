package problemSet_1;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/submissions/
public class GenerateParentheses {

    static int stackNumber = 0;
    public static void main (String[] arg) {
        System.out.println(generateParenthesis2(3));
    }


    public static List<String> generateParenthesis2(int n) {
        List<String> results = new ArrayList<String>();
        backTracking(results, new String(), n, n);
        return results;
    }

    static void backTracking(List<String> results, String currentString, int open, int close){
        //System.out.println("stackNumber" + stackNumber++);
        int stack = ++stackNumber;
        if (close == 0) {
            results.add(currentString);
            System.out.println("stackNumber" + stack + " Returning currentString  " + currentString);
            return;
        }

        if (open > 0) {
            System.out.println("stackNumber" + stack + " adding open currentString " + currentString + "(");
            backTracking(results, currentString + "(", open -1, close);
        }

        // Close will only be allowed when open was added in earlier stack. Not this stack.
        // This stack open addition would be removed by this line number.
        if (close > open) {
            stackNumber = stack;
            System.out.println("stackNumber" + stack + " adding close currentString " + currentString + ")");
            backTracking(results, currentString + ")" , open , close -1);
        }
    }


    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList();
        generate(results, 0, 0, "", n);
        return results;
    }

    private static void generate(List<String> results, int openCount, int closeCount, String currentString, int maxCount) {

        if (currentString.length() == 2 * maxCount) {
            results.add(currentString);
            return;
        }

        // Rather than modifying currentString withing the method and remove the modification after stack come again back,
        // Place the modification in method call rather than directly modifying within the method

        if (openCount < maxCount)
            generate(results, openCount+1, closeCount, currentString + "(", maxCount);

        if (closeCount < openCount)
            generate(results, openCount, closeCount+1, currentString + ")", maxCount);
    }
}
