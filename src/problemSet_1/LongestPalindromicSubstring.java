package problemSet_1;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean [][] matrix = new boolean[s.length()][s.length()];
        String output = "";
        for(int m = 0; m < s.length(); m ++) {
            int i = 0, j = m;
            while(j < s.length()) {
                if (i == j) {
                    matrix[i][j] = true;
                }
                else if (s.charAt(i) == s.charAt(j)) {
                    if (j-i == 1) {
                        matrix[i][j] = true;
                    } else
                        matrix[i][j] = matrix[i+1][j-1];
                }

                if (matrix[i][j]) {
                    output = s.substring(i, j+1);
                }
                i++; j++;
            }
        }
        return output;
    }

/*
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];

        String ans = ((Character)s.charAt(0)).toString();

        for(int m = 0; m < len; m++) {
            for (int i = 0, j = m; j < len; i++, j++) {
                if (i == j) {
                    matrix[i][j] = true;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j) && ( j-i==1 || matrix[i+1][j-1])) {
                    matrix[i][j] = true;
                    if (j-i+1 > ans.length())
                        ans = s.substring(i, j+1);

                }
            }
        }
        return ans;
    }

    */
}
