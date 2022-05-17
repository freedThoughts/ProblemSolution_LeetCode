package problemSet_1;

import java.util.Stack;
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
public class KthSmallestElementInaBst {

    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
                count++;
                if (count == k) return node.val;
                node = node.right;
            }

            while(node!= null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            count++;
            if (count == k)
                return node.val;

            node = node.right;
        }

        return -1;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
