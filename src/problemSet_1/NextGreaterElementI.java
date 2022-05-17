package problemSet_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// https://leetcode.com/problems/next-greater-element-i/submissions/
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < nums2[i])
                stack.pop();
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] results = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            results[i] = map.get(nums1[i]);
        }
        return results;


    }
}
