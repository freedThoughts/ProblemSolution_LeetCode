package problemSet_1;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] matrix = new int[grid.length][grid[0].length];
        matrix[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
        for(int i = grid[0].length-2; i >= 0; i--) {
            matrix[grid.length-1][i] = grid[grid.length-1][i] + matrix[grid.length-1][i+1];
        }

        for (int i = grid.length-2; i >= 0; i--) {
            matrix[i][grid[0].length-1] = grid[i][grid[0].length-1] + matrix[i+1][grid[0].length-1];
        }

        for (int i = grid.length-2; i >= 0; i--) {
            for (int j = grid[0].length-2; j >= 0; j--) {
                matrix[i][j] = grid[i][j] + Math.min(matrix[i+1][j], matrix[i][j+1]);
            }
        }
        return matrix[0][0];
    }
}
