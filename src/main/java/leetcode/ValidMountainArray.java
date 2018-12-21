package leetcode;

/**
 * Created by lyk on 2018-12-21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }

    public static void main(String[] args) {
        ValidMountainArray vma = new ValidMountainArray();
        System.out.println(vma.validMountainArray(new int[]{2, 1}));
        System.out.println(vma.validMountainArray(new int[]{2, 3}));
        System.out.println(vma.validMountainArray(new int[]{2, 5, 6, 1, 0}));

    }
}
