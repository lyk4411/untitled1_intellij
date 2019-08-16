package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2019-8-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DeleteColumnstoMakeSortedIII {
    public int minDeletionSize(String[] A) {
        int W = A[0].length();
        int[] dp = new int[W];
        Arrays.fill(dp, 1);
        for (int i = W-2; i >= 0; --i)
            search: for (int j = i+1; j < W; ++j) {
                for (String row: A)
                    if (row.charAt(i) > row.charAt(j))
                        continue search;

                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }

        int kept = 0;
        for (int x: dp)
            kept = Math.max(kept, x);
        return W - kept;
    }

    public static void main(String[] args) {
        DeleteColumnstoMakeSortedIII dcmsiii =
                new DeleteColumnstoMakeSortedIII();
        String[] A1 = new String[]{"babca","bbazb"};
        String[] A2 = new String[]{"edcba"};
        String[] A3 = new String[]{"ghi","def","abc"};
        System.out.println(dcmsiii.minDeletionSize(A1));
        System.out.println(dcmsiii.minDeletionSize(A2));
        System.out.println(dcmsiii.minDeletionSize(A3));
    }
}
