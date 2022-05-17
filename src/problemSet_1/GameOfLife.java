package problemSet_1;

public class GameOfLife {
// https://leetcode.com/problems/game-of-life/submissions/
    public static void main(String[] arg) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        //gameOfLife(board);
        System.out.println(board);

    }

    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = evaluate(board, i, j);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 10) board[i][j] = 1;
                else if (board[i][j] == -10) board[i][j] = 0;
            }
        }
    }

    int evaluate(int[][] board, int i, int j) {
        int liveCount = 0;
        if (i != 0 && (board[i-1][j] == 1 || board[i-1][j] == -10)) liveCount++;
        if (i != 0 && j != 0 && (board[i-1][j-1] == 1 || board[i-1][j-1] == -10)) liveCount++;
        if (i != 0 && j != (board[0].length-1) && (board[i-1][j+1] == 1 || board[i-1][j+1] == -10)) liveCount++;
        if (j != 0 && (board[i][j-1] == 1 || board[i][j-1] == -10)) liveCount++;
        if (j != board[0].length-1 && (board[i][j+1] == 1 || board[i][j+1] == -10)) liveCount++;
        if (i != board.length-1 && (board[i+1][j] == 1 || board[i+1][j] == -10)) liveCount++;
        if (i != board.length-1 && j != 0 && (board[i+1][j-1] == 1 || board[i+1][j-1] == -10)) liveCount++;
        if (i != board.length-1 && j != board[0].length-1 && (board[i+1][j+1] == 1 || board[i+1][j+1] == -10) )liveCount++;

        if (board[i][j] == 0 && liveCount == 3) return 10;
        if (board[i][j] == 1 && !(liveCount == 2 || liveCount == 3)) return -10;
        return board[i][j];
    }
}
