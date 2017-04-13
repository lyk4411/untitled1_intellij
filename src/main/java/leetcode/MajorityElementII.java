package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2017/4/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MajorityElementII {
    public static void main(String[] args) {
        MajorityElementII meii = new MajorityElementII();
        int[] nums1 = new int[]{1,2,3,4,5,6,7,8};
        int[] nums2 = new int[]{1,2,1,2,1,1,1,2,2,2,1,1};
        System.out.println(meii.majorityElement(nums1));
        System.out.println(meii.majorityElement(nums2));
    }
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0) + 1);
//            if(map.containsKey(i)){
//                map.put(i, map.get(i)+1);
//            }else{
//                map.put(i, 1);
//            }
        }

        List<Integer> result = new ArrayList<Integer>();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > nums.length/3){
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
