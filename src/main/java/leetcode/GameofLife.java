package leetcode;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GameofLife {
    public static void main(String[] args) {
        GameofLife gl = new GameofLife();
        int[][] boards = new int[][]{{0,1,0,1},{0,1,0,1},{0,1,0,1},{0,1,0,1}};
        gl.gameOfLife(boards);
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                System.out.print(boards[i][j]);
            }
            System.out.println();
        }

    }
    public void gameOfLife(int[][] board) {
        //check input
        if(board==null || board.length==0 || board[0]==null || board[0].length==0) return;

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int x = getLiveNum(board, i, j);
                if(board[i][j] == 0) {
                    if(x==3) board[i][j]+=10;
                } else {
                    if(x==2 || x==3) board[i][j]+=10;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] /= 10;
            }
        }
    }

    private int getLiveNum(int[][] board, int x, int y) {
        int c=0;
        for(int i=x-1; i<=x+1; i++) {
            for(int j=y-1; j<=y+1; j++) {
                if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || (i==x && j==y)) continue;
                if(board[i][j]%10==1) c++;
            }
        }
        return c;
    }
}

