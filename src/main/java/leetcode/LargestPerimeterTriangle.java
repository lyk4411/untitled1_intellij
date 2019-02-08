package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2019-2-8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle lpt = new LargestPerimeterTriangle();
        System.out.println(lpt.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(lpt.largestPerimeter(new int[]{1, 1, 2}));
        System.out.println(lpt.largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}
