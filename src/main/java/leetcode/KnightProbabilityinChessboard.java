package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-6-12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KnightProbabilityinChessboard {
    public double knightProbability(int N, int K, int r, int c) {
        int [][] moves = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
        double [][] dp0 = new double[N][N];
        for(double [] row : dp0){
            Arrays.fill(row, 1);
        }

        for(int step = 0; step<K; step++){
            double [][] dp1 = new double[N][N];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    for(int [] move : moves){
                        int row = i + move[0];
                        int col = j + move[1];
                        if(isIllegal(row, col, N)){
                            dp1[row][col] += dp0[i][j];
                        }
                    }
                }
            }
            dp0 = dp1;
        }
        return dp0[r][c]/Math.pow(8,K);
    }

    private boolean isIllegal(int row, int col, int len){
        return row>=0 && row<len && col>=0 && col<len;
    }


    public static void main(String[] args) {
        KnightProbabilityinChessboard kpc = new KnightProbabilityinChessboard();
        System.out.println(kpc.knightProbability(3, 2, 0, 0));
    }
}
