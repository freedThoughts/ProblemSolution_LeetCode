package problemSet_1;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {

    public static void main(String[] s){
        char[][] chars = new char[][]
                {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(chars));
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < board.length; row++) {
            Set<Character> set = new HashSet();
            for (int col = 0; col < board.length; col++) {
                char c = board[row][col];
                // ANCII VALUE CONVERSION *****************
                if (!(c == '.' || (c >= 49 && c <= 57))){
                    return false;
                }
                if (c == '.')
                    continue;
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }

        for (int col = 0; col < board.length; col ++) {
            Set<Character> set = new HashSet();
            for (int row = 0; row < board.length; row++){
                Character c = board[row][col];
                if (c == '.')
                    continue;
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }

        for (int row = 0; row < board.length; row = row + 3) {
            for (int col = 0; col < board.length; col = col + 3) {
                Set<Character> set = new HashSet();
                for (int m = row; m < row+3; m++) {
                    for (int n = col; n < col+3; n++ ) {
                        Character c = board[m][n];
                        if (c == '.')
                            continue;
                        if (set.contains(c)) {
                            return false;
                        }
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }
}
