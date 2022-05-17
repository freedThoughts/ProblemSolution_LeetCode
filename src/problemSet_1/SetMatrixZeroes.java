package problemSet_1;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/set-matrix-zeroes/submissions/
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Node> set = new HashSet<>();

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    set.add(new Node(i, j));
                }
            }
        }

        for(Node node : set) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[node.row][j] = 0;
            for (int i = 0; i < matrix.length; i++)
                matrix[i][node.col] = 0;
        }
    }

    private static class Node {
        Integer row;
        int col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
