package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lyk on 2017/6/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RussianDollEnvelopes {
    public static void main(String[] args) {
        RussianDollEnvelopes rde = new RussianDollEnvelopes();
        int[][] enevlopes = new int[][]{
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        System.out.println(rde.maxEnvelopes(enevlopes));
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (   envelopes           == null
                || envelopes.length    == 0
                || envelopes[0]        == null
                || envelopes[0].length == 0){
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return Integer.compare(e1[0], e2[0]);
            }
        });

        int   n  = envelopes.length;
        int[] dp = new int[n];

        int ret = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;

            for (int j = 0; j < i; j++){
                if (   envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
