package leetcode;

import java.util.ArrayList;

/**
 * Created by lyk on 2018-12-27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SumSegmentTree {
    private ArrayList<Integer> sumSegmentTree;
    private int n;

    public SumSegmentTree(int[] arr) {
        n = arr.length;
        sumSegmentTree = new ArrayList<>(2 * n);
        for (int i = 0; i < n; i++) {
            sumSegmentTree.add(0);
        }
        for (int i = 0; i < n; i++) {
            sumSegmentTree.add(arr[i]);
        }
        for (int i = n - 1; i > 0; i--) {
            sumSegmentTree.set(i, sumSegmentTree.get(2 * i) + sumSegmentTree.get(2 * i + 1));
        }
    }

    public void update(int i, int value) {
        i += n;
        sumSegmentTree.set(i, value);
        while (i > 1) {
            i /= 2;
            sumSegmentTree.set(i, sumSegmentTree.get(2 * i) + sumSegmentTree.get(2 * i + 1));
        }
    }

    /**
     * Get the sum of range [left, right)
     */
    public int sum(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left < right) {
            if ((left & 1) == 1) {
                sum += sumSegmentTree.get(left);
                left++;
            }
            if ((right & 1) == 1) {
                right--;
                sum += sumSegmentTree.get(right);
            }
            left >>= 1;
            right >>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumSegmentTree sst = new SumSegmentTree(new int[]{1, 2, 4, 6, 8, 9, 1, 4});
        System.out.println(sst.sum(0,5));
        System.out.println(sst.sumSegmentTree);
    }
}
