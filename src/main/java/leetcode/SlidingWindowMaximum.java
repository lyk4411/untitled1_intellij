package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2017/6/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] numsnull = null;
        int[] results = swm.maxSlidingWindow(nums,3);
        int[] results1 = swm.maxSlidingWindow(numsnull,3);
        for (int i = 0; i < results.length; i++) {
            System.out.print("results[" + i + "]:" + results[i] + ";  ");
        }
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
        new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        }
    );

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[0];
        int n = nums.length - k + 1;
        if (n <= 0) return new int[0];
        int[] result = new int[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = maxHeap.peek();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return result;
    }

    private void remove(int num) {
        maxHeap.remove(num);
        //System.out.println("after remove maxHeap:" + maxHeap + "  ");
    }

    private void add(int num) {
        maxHeap.add(num);
        //System.out.println("maxHeap:" + maxHeap + "  ");
    }
}
