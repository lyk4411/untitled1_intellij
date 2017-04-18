package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2017/4/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        IntersectionofTwoArraysII itaii = new IntersectionofTwoArraysII();
        int[] nums1 = new int[]{1,2,3,1,2,3};
        int[] nums2 = new int[]{1,2,3,1,2,3};
        IntStream.of(itaii.intersect(nums1,nums2)).forEach(a -> System.out.print(a + ":"));

    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }

        return r;
    }
}
