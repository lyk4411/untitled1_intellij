package leetcode;

/**
 * Created by lyk on 2017/5/26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BattleshipsinaBoard {
    public static void main(String[] args) {
        BattleshipsinaBoard bb = new BattleshipsinaBoard();
        char[][] boards = new char[][]{
                {'X','X','.','X'},
                {'.','.','.','X'},
                {'.','.','.','X'},
                {'X','.','.','X'}
        };
        System.out.println(bb.countBattleships(boards));
    }
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;

        int count=0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }

        return count;
    }
}

