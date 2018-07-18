package leetcode;

/**
 * Created by lyk on 2018-7-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TransformtoChessboard {
    public int movesToChessboard(int[][] board) {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        任何棋盘内部的四边形，要么四个角都是1，要么四个角都是0，要么两个0和两个1。
        int N = board.length, colToMove = 0, rowToMove = 0, rowOneCnt = 0, colOneCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[i][j] ^ board[0][j]) == 1) {
                    return -1;
                }
            }
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        只能有且仅有两种行类型，例如如果一种行类型为01010011，
//        那么另外一种行类型只能为01010011或者10101100；该限制条件同样适合于列类型。
        for (int i = 0; i < N; i++) {
            rowOneCnt += board[0][i];
            colOneCnt += board[i][0];
            if (board[i][0] == i % 2) {
                rowToMove++;
            }
            if (board[0][i] == i % 2) {
                colToMove++;
            }
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        每一行和每一列中，0和1的数量都是相等的，假设棋盘是N * N大小的，
//        那么：a）如果N = 2 * K，那么每一行每一列有且仅有K个0和K个1；
//              b）如果N = 2 * K + 1，那么每一行每一列要么有K个1和K+1个0，要么有K+1个1和K个0
        if (rowOneCnt < N / 2 || rowOneCnt > (N + 1) / 2) {
            return -1;
        }
        if (colOneCnt < N / 2 || colOneCnt > (N + 1) / 2) {
            return -1;
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        1）如果N是偶数，我们计算实现01010和10101需要的最小移动步数，并且取最小者；
//        2）如果N是奇数，我们就只有一种取法，所以就取移动步数为偶数的最小次数。
        if (N % 2 == 1) {
            // we cannot make it when ..ToMove is odd
            if (colToMove % 2 == 1) {
                colToMove = N - colToMove;
            }
            if (rowToMove % 2 == 1) {
                rowToMove = N - rowToMove;
            }
        } else {
            colToMove = Math.min(colToMove, N - colToMove);
            rowToMove = Math.min(rowToMove, N - rowToMove);
        }
        return (colToMove + rowToMove) / 2;
    }

    public static void main(String[] args) {
        TransformtoChessboard tc = new TransformtoChessboard();
        int[][] b1 = new int[][]{
                {0,1,1,0},{0,1,1,0},{1,0,0,1},{1,0,0,1}
        };
        int[][] b2 = new int[][]{
                {0,1},{1,0}
        };
        int[][] b3 = new int[][]{
                {1,0},{1,0}
        };
        System.out.println(tc.movesToChessboard(b1));
        System.out.println(tc.movesToChessboard(b2));
        System.out.println(tc.movesToChessboard(b3));
    }
}
