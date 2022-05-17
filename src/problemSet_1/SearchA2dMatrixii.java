package problemSet_1;

// https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
public class SearchA2dMatrixii {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;

        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) return true;
            if(target > matrix[i][j] ) {
                i++;
                continue;
            }
            j--;
        }

        return false;
    }

}
