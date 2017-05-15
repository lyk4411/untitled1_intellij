package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2017/5/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindKPairswithSmallestSums {
    public static void main(String[] args) {
        FindKPairswithSmallestSums fp = new FindKPairswithSmallestSums();
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{2,1,4};
        List<int[]> list = fp.kSmallestPairs(nums1,nums2,3);
        Iterator it = list.iterator();
        while (it.hasNext()){
            int[] temp = (int[]) it.next();
            System.out.print("[");
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i] + ";");
            }
            System.out.println("]");
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}
