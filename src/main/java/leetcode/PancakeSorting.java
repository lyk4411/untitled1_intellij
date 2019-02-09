package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2019-2-9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PancakeSorting {
    public void reverse(int[] A, int l, int r) {
        while (l < r) {
            int tmp = A[l];
            A[l] = A[r];
            A[r] = tmp;
            l++;
            r--;
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList();
        int[] Abackup = new int[A.length];
        for (int i = 0; i < Abackup.length; i++) Abackup[i] = A[i];
        Arrays.sort(Abackup);
        for (int i = Abackup.length - 1; i >= 0; i--) {
            int j = Abackup.length - 1;
            for (; j >= 0; j--) if (A[j] == Abackup[i]) break;
            if (i == j) continue;
            if (j != 0) {
                res.add(j + 1);
                reverse(A, 0, j);
            }
            res.add(i + 1);
            reverse(A, 0, i);
        }
        return res;
    }

    public static void main(String[] args) {
        PancakeSorting ps = new PancakeSorting();
        System.out.println(ps.pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(ps.pancakeSort(new int[]{1, 2, 3, 4}));
    }
}
