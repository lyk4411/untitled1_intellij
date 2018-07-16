package leetcode;

import java.util.PriorityQueue;

/**
 * Created by lyk on 2018-7-15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KthLargest {
    int[] nums;
    int k;
    PriorityQueue<Integer> p = new PriorityQueue<Integer>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        findKthLargest(nums, k);
    }
    public int findKthLargest(int[] nums, int k) {

        for(int i = 0 ; i < nums.length; i++){
            p.add(nums[i]);
            if(p.size() > k) p.poll();
        }
        if(p.size() > 0){
            return p.peek();
        } else {
            return -1;
        }
    }

    public int add(int val) {
        if(p.size() < k){
            p.add(val);
        }else if(val > p.peek()){
            p.add(val);
            p.poll();
        }
        return p.peek();
    }

    public static void main(String[] args) {
        KthLargest kl = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kl.add(3));
        System.out.println(kl.add(5));
        System.out.println(kl.add(10));
        System.out.println(kl.add(9));
        System.out.println(kl.add(4));
        KthLargest k2 = new KthLargest(1, new int[]{});
        System.out.println(k2.add(-3));
        System.out.println(k2.add(-2));
        System.out.println(k2.add(-4));
        System.out.println(k2.add(0));
        System.out.println(k2.add(4));
    }
}
