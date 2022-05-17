package problemSet_1;

// https://leetcode.com/problems/interleaving-string/submissions/
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] matrix = new boolean[s1.length()+1][s2.length()+1];
        matrix[0][0] = true;
        for(int i = 1; i < matrix.length; i++)
            matrix[i][0] = s1.charAt(i-1) == s3.charAt(i-1) ? matrix[i-1][0] : false;

        for (int j = 1; j < matrix[0].length; j++)
            matrix[0][j] = s2.charAt(j-1) == s3.charAt(j-1) ? matrix[0][j-1] : false;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                boolean result = s1.charAt(i-1) == s3.charAt(i+j-1) ? matrix[i-1][j] : false;
                if (!result)
                    result = s2.charAt(j-1) == s3.charAt(i+j-1) ? matrix[i][j-1] : false;
                matrix[i][j] = result;
            }
        }

        return matrix[s1.length()][s2.length()];
    }
}
