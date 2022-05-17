package problemSet_1;

// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        Integer row = getRowIndex(matrix, target, 0, matrix.length-1);
        if (row == null) return false;
        return search(matrix, row, 0, matrix[0].length-1, target);
    }

    Integer getRowIndex(int[][] matrix, int target, int start, int end) {
        if (start > end) return null;
        if (start == end) return start;
        int midIndex = start + (end - start)/2;
        if (matrix[midIndex][0] == target) return midIndex;
        if (matrix[midIndex][0] > target)
            return getRowIndex(matrix, target, start, midIndex-1);

        if (midIndex == matrix.length-1) return midIndex;
        if (matrix[midIndex+1][0] > target) return midIndex;
        return getRowIndex(matrix, target, midIndex+1, end);
    }

    boolean search(int[][] matrix, int row, int start, int end, int target) {
        if (start > end) return false;
        int midIndex = start + (end-start)/2;
        if (matrix[row][midIndex] == target) return true;
        if (matrix[row][midIndex] > target) return search(matrix, row, 0, midIndex-1, target);
        return search(matrix, row, midIndex+1, end, target);
    }
}
