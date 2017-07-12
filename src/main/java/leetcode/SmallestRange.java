package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2017/7/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SmallestRange {

    public static void main(String[] args) {
        SmallestRange sr = new SmallestRange();
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a3 = new ArrayList<>();
        a1.add(0,26);
        a1.add(0,24);
        a1.add(0,15);
        a1.add(0,10);
        a1.add(0,4);
        a2.add(0,20);
        a2.add(0,12);
        a2.add(0,9);
        a2.add(0,0);
        a3.add(0,30);
        a3.add(0,22);
        a3.add(0,18);
        a3.add(0,5);
        nums.add(0,a1);
        nums.add(0,a2);
        nums.add(0,a3);
        int[] results = sr.smallestRange(nums);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " : ");
        }
        System.out.println();
    }
    public int[] smallestRange(List<List<Integer>>  nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.size()) {

            Element curr = pq.poll();
            if (max - curr.val < range) {
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums.get(curr.row).size()) {
                curr.idx = curr.idx + 1;
                curr.val = nums.get(curr.row).get(curr.idx);
                pq.offer(curr);
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[] { start, end };
    }

    class Element {
        int val;
        int idx;
        int row;

        public Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }
}
