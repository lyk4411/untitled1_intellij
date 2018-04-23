package leetcode;

import java.util.*;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> count = new HashMap();
        List<Pair1> counted = new ArrayList();
        for (int x: arr) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            counted.add(new Pair1(x, count.get(x)));
        }

        List<Pair1> expect = new ArrayList(counted);
        Collections.sort(expect, (a, b) -> a.compare(b));

        Pair1 cur = counted.get(0);
        int ans = 0;
        for (int i = 0; i < arr.length; ++i) {
            Pair1 X = counted.get(i), Y = expect.get(i);
            if (X.compare(cur) > 0) cur = X;
            if (cur.compare(Y) == 0) ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII mctmsii = new MaxChunksToMakeSortedII();
        int[] nums1 = new int[]{4,3,2,1,0};
        int[] nums2 = new int[]{1,0,2,3,4};
        int[] nums3 = new int[]{1,2,0,3};
        int[] nums4 = new int[]{2,1,3,4,4};

        System.out.println(mctmsii.maxChunksToSorted(nums1));
        System.out.println(mctmsii.maxChunksToSorted(nums2));
        System.out.println(mctmsii.maxChunksToSorted(nums3));
        System.out.println(mctmsii.maxChunksToSorted(nums4));
    }
}



class Pair1 {
    int val;
    int count;
    Pair1(int v, int c) {
        val = v;
        count = c;
    }
    int compare(Pair1 that) {
        return this.val != that.val ? this.val - that.val : this.count - that.count;
    }
}