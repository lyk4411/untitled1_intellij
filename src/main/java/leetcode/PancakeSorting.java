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
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i+1;
        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);

        for (int i: B) {
            for (int f: ans)
                if (i <= f)
                    i = f+1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }

    public static void main(String[] args) {
        PancakeSorting ps = new PancakeSorting();
        System.out.println(ps.pancakeSort(new int[]{3,2,4,1}));
        System.out.println(ps.pancakeSort(new int[]{1,2,3,4}));
    }
}
