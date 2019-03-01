package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2019-3-1.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i].start, B[j].start);
            int hi = Math.min(A[i].end, B[j].end);
            if (lo <= hi)
                ans.add(new Interval(lo, hi));

            // Remove the interval with the smallest endpoint
            if (A[i].end < B[j].end)
                i++;
            else
                j++;
        }

        return ans.toArray(new Interval[ans.size()]);
    }

    public static void main(String[] args) {
        IntervalListIntersections ili = new IntervalListIntersections();
        Interval a1 = new Interval(0, 2);
        Interval a2 = new Interval(5, 10);
        Interval a3 = new Interval(13, 23);
        Interval a4 = new Interval(24, 25);
        Interval b1 = new Interval(1, 5);
        Interval b2 = new Interval(8, 12);
        Interval b3 = new Interval(15, 24);
        Interval b4 = new Interval(25, 26);
        Interval[] a = new Interval[]{a1, a2, a3, a4};
        Interval[] b = new Interval[]{b1, b2, b3, b4};
        Interval[] result = ili.intervalIntersection(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
