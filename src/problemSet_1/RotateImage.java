package problemSet_1;

public class RotateImage {

    public static void main(String[] arg) {
        int[][] matrix = new int[][] {
                {1,2,3},{4,5,6},{7,8,9}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    // Anti-clock wise
    // Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    // [1,2,3]   --> is row 0. Don't get confuse with [7,8,9] as row 0 ****************************
    public static void rotate(int[][] matrix) {
        for (int startRange = 0, endRange = matrix.length-1; startRange < endRange; startRange++, endRange--) {

            for(int i = startRange; i < endRange; i++) {
                int j = startRange;

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][endRange-i];
                matrix[j][endRange-i] = matrix[endRange-i][endRange];
                matrix[endRange-i][endRange] = matrix[endRange][i];
                matrix[endRange][i] = temp;
            }
        }
    }
}
