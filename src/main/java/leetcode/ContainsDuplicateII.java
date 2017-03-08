package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        ContainsDuplicateII cdii = new ContainsDuplicateII();
        int[] nums = new int[]{1,2,3,4,5,6,7,4};
        System.out.println(cdii.containsNearbyDuplicate(nums,4));
        System.out.println(cdii.containsNearbyDuplicate(nums,3));

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
