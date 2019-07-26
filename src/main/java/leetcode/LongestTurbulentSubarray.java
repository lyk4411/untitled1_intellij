package leetcode;

/**
 * Created by lyk on 2019-7-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestTurbulentSubarray lts = new LongestTurbulentSubarray();
        int[] A1 = new int[]{9,4,2,10,7,8,8,1,9};
        int[] A2 = new int[]{1,2,3,4,5};
        int[] A3 = new int[]{100};
        System.out.println(lts.maxTurbulenceSize(A1));
        System.out.println(lts.maxTurbulenceSize(A2));
        System.out.println(lts.maxTurbulenceSize(A3));
    }
}
