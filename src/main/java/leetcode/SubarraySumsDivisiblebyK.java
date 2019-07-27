package leetcode;

/**
 * Created by lyk on 2019-7-27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        int[] count = new int[K];
        for (int x: P)
            count[(x % K + K) % K]++;

        int ans = 0;
        for (int v: count)
            ans += v * (v - 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
        SubarraySumsDivisiblebyK ssdk = new SubarraySumsDivisiblebyK();
        int[] A = new int[]{4, 5, 0, -2, -3, 1};
        int K = 5;
        System.out.println(ssdk.subarraysDivByK(A, K));
    }
}
