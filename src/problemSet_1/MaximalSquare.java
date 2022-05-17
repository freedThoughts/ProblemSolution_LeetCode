package problemSet_1;
// https://leetcode.com/problems/maximal-square/submissions/
public class MaximalSquare {

    public static void main(String[] arg) {
        System.out.println(maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }

    public static int maximalSquare(char[][] matrix) {

        int ans  = 0;

        Node[][] nodeMatrix = new Node[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') continue;
                if (i == 0 || j == 0) {
                    Node node = new Node(1, 1);
                    node.len = 1;
                    nodeMatrix[i][j] = node;
                    if (node.len > ans) ans = node.len;
                    continue;
                }

                int rowSum = nodeMatrix[i-1][j] == null ? 0 : nodeMatrix[i-1][j].rowSum;
                int colSum = nodeMatrix[i][j-1] == null ? 0 : nodeMatrix[i][j-1].colSum;
                int len = Math.min(rowSum, colSum);
                if (nodeMatrix[i-1][j-1] == null) len = 1;
                else len = Math.min(nodeMatrix[i-1][j-1].len, len) +1;
                nodeMatrix[i][j] = new Node(rowSum +1, colSum+1);
                nodeMatrix[i][j].len = len;
                if (len > ans) ans = len;
            }
        }

        return ans*ans;
    }

    static class Node {
        int rowSum;
        int colSum;
        int len;

        public Node(int rowSum, int colSum) {
            this.rowSum = rowSum;
            this.colSum = colSum;
        }
    }
}
