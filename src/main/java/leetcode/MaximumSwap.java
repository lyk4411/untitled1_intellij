package leetcode;

/**
 * Created by lyk on 2018-4-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        System.out.println(ms.maximumSwap(7247));
        System.out.println(ms.maximumSwap(724));

    }
}
