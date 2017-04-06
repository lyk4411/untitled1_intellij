package leetcode;

/**
 * Created by lyk on 2017/4/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        char[][] boards = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        ss.solveSudoku(boards);
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                System.out.print(boards[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (j >= 9)
            return solve(board, i + 1, 0);
        if (i == 9)
            return true;
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j)) {
                    if (solve(board, i, j + 1))
                        return true;
                }
                board[i][j] = '.';
            }
        } else {
            return solve(board, i, j + 1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j])
                return false;
        }
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j])
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (row != i && col != j && board[i][j] == board[row][col])
                    return false;
            }
        }
        return true;
    }



//    public void solveSudoku(char[][] board) {
//        solve(board);
//    }
//
//    public boolean solve(char[][] board){
//        for(int i=0; i<9; i++){
//            for(int j=0; j<9; j++){
//                if(board[i][j]!='.')
//                    continue;
//
//                for(int k=1; k<=9; k++){
//                    board[i][j] = (char) (k+'0');
//                    if(isValid(board, i, j) && solve(board))
//                        return true;
//                    board[i][j] = '.';
//                }
//
//                return false;
//            }
//        }
//
//        return true; // does not matter
//    }
//
//    public boolean isValid(char[][] board, int i, int j){
//        HashSet<Character> set = new HashSet<Character>();
//
//        for(int k=0; k<9; k++){
//            if(set.contains(board[i][k]))
//                return false;
//
//            if(board[i][k]!='.' ){
//                set.add(board[i][k]);
//            }
//        }
//
//        set.clear();
//
//        for(int k=0; k<9; k++){
//            if(set.contains(board[k][j]))
//                return false;
//
//            if(board[k][j]!='.' ){
//                set.add(board[k][j]);
//            }
//        }
//
//        set.clear();
//
//        for(int m=0; m<3; m++){
//            for(int n=0; n<3; n++){
//                int x=i/3*3+m;
//                int y=j/3*3+n;
//                if(set.contains(board[x][y]))
//                    return false;
//
//                if(board[x][y]!='.'){
//                    set.add(board[x][y]);
//                }
//            }
//        }
//
//        return true;
//    }
}
