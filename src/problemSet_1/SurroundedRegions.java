package problemSet_1;
// https://leetcode.com/problems/surrounded-regions/submissions/
public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length-1);
        }

        for (int j = 1; j < board[0].length-1; j++){
            dfs(board, 0, j);
            dfs(board, board.length-1, j);
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    void dfs(char[][] board, int i, int j) {

        if (i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1) return;
        if (board[i][j] != 'O') return;

        board[i][j] = 'A';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
