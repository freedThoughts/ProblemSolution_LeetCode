package problemSet_1;
// https://leetcode.com/problems/sum-of-left-leaves/submissions/
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode node) {
        if (node == null) return 0;
        int leftVal = 0;
        if (node.left == null) {
            leftVal = 0;
        } else if (node.left.left == null && node.left.right == null) {
            leftVal = node.left.val;
        } else {
            leftVal = sumOfLeftLeaves( node.left);
        }

        int rightVal = sumOfLeftLeaves( node.right);

        return leftVal + rightVal;
    }
}
