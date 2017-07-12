package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2017/7/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SmallestRange {
    class Element {
        int val;
        int idx;
        int row;

        public Element(int r, int i, int v) {
            row = r;
            idx = i;
            val = v;
        }
    }

    public static void main(String[] args) {
        SmallestRange sr = new SmallestRange();
        int[][] nums = new int[][]{
                {4,10,15,24,26},
                {0,9,12,20},
                {5,18,22,30}
        };
        int[] results = sr.smallestRange(nums);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " : ");
        }
        System.out.println();
    }
    public int[] smallestRange(int[][] nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Element e = new Element(i, 0, nums[i][0]);
            pq.offer(e);
            max = Math.max(max, nums[i][0]);
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.length) {

            Element curr = pq.poll();
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums[curr.row].length) {
                curr.idx = curr.idx + 1;
                curr.val = nums[curr.row][curr.idx];
                pq.offer(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[] { start, end };
    }
}
