package leetcode;

/**
 * Created by lyk on 2018-12-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r+1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
    }

    public static void main(String[] args) {
        DeleteColumnstoMakeSorted dcms = new DeleteColumnstoMakeSorted();
        String[] A = new String[]{"cba","daf","ghi"};
        System.out.println(dcms.minDeletionSize(A));
    }
}
