package leetcode;

/**
 * Created by lyk on 2019-2-6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RLEIterator {
    int[] A;
    int i, q;

    public RLEIterator(int[] A) {
        this.A = A;
        i = q = 0;
    }

    public int next(int n) {
        while (i < A.length) {
            if (q + n > A[i]) {
                n -= A[i] - q;
                q = 0;
                i += 2;
            } else {
                q += n;
                return A[i+1];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RLEIterator rlei = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(rlei.next(2));
        System.out.println(rlei.next(1));
        System.out.println(rlei.next(1));
        System.out.println(rlei.next(2));

    }

}
