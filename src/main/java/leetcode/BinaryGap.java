package leetcode;

/**
 * Created by lyk on 2018-7-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.binaryGap(8));
        System.out.println(bg.binaryGap(5));
        System.out.println(bg.binaryGap(6));
    }
}
