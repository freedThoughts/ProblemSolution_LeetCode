package problemSet_1;

// https://leetcode.com/problems/house-robber-iii/submissions/
public class HouseRobberiii {

    public int rob(TreeNode root) {
        int[] result = robbery(root);
        return Math.max(result[0], result[1]);
    }

    int[] robbery(TreeNode node) {
        if (node == null) return new int[] {0, 0};
        int[] leftResult = robbery(node.left);
        int[] rightResult = robbery(node.right);

        int withVal = node.val + leftResult[1] + rightResult[1];
        int withoutVal = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);

        return new int[] {withVal, withoutVal};

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
