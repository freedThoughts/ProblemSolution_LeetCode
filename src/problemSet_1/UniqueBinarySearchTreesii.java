/*
package problemSet_1;

import java.util.List;

//https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesii {

    public List<TreeNode> generateTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int val = 0;
            for(int j = 0; j < n; j++) {
                val = val + dp[j] * dp[n-1-j];
            }
            dp[i] = val;
        }

        return dp[n];

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
*/
